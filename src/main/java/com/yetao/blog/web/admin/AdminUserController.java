package com.yetao.blog.web.admin;

import com.yetao.blog.entity.User;
import com.yetao.blog.result.ResponseResult;
import com.yetao.blog.service.UserService;
import com.yetao.blog.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yetao
 * @Date 2020/9/11 15:50
 * @Description 管理员接口类
 */
@RestController
@RequestMapping("admin")
@Api(tags = "管理员接口")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("初始化管理员账号")
    @PostMapping("init")
    public ResponseResult init(@RequestBody User user, HttpServletRequest request) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return ResponseResult.failed("用户名或密码不能为空");
        }
        if (StringUtils.isEmpty(user.getEmail())) {
            return ResponseResult.failed("邮箱不能为空");
        }
        if (userService.initAdmin(user, request)) {
            return ResponseResult.success("账号初始化成功");
        }
        return ResponseResult.success("账号初始化失败");
    }

    @ApiOperation("管理员登录")
    @PostMapping("login")
    public ResponseResult login(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("captcha_key") String captchaKey,
                                @RequestParam("captcha_value") String captchaValue,
                                HttpServletRequest request, HttpServletResponse response) {

        if (!captchaValue.equals(redisUtil.get(captchaKey))) {
            return ResponseResult.failed("验证码错误");
        }
        if (!userService.login(username, password, captchaKey, captchaValue, request, response)) {
            return ResponseResult.failed("登录失败");
        }
        return ResponseResult.success("登录成功");
    }

    @ApiOperation("退出登录")
    @PostMapping("logout")
    public ResponseResult logout() {
        return null;
    }

    @ApiOperation("获取管理员账号信息")
    @GetMapping("info/{id}")
    public ResponseResult getAdminInfo(@PathVariable("id") String id) {
        User user = userService.getAdminInfo(id);
        return ResponseResult.success("获取信息成功", user);
    }

    @ApiOperation("修改管理员账号信息")
    @PutMapping("update")
    public ResponseResult updateAdminInfo(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getRole())) {
            return ResponseResult.failed("角色不能为空");
        }
        if (!userService.updateAdminInfo(user)) {
            return ResponseResult.failed("修改失败");
        }
        return ResponseResult.success("修改成功");
    }
}
