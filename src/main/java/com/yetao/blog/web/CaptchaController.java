package com.yetao.blog.web;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.yetao.blog.result.ResponseResult;
import com.yetao.blog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yetao
 * @date 2021/1/7 16:07
 * @description 验证码接口
 */
@RestController
@RequestMapping("blog")
public class CaptchaController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("captcha-base64")
    public ResponseResult getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = IdWorker.getIdStr();
        redisUtil.set(key, verCode, 60 * 10 * 3);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("key", key);
        map.put("image", specCaptcha.toBase64());
        return ResponseResult.success("获取验证码成功！", map);
    }

    @GetMapping("captcha-image")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体 有默认字体，可以不用设置
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 验证码存入session
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        redisUtil.set(IdWorker.getIdStr(), specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }
}
