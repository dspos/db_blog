package com.yetao.blog.service.impl;

import com.yetao.blog.mapper.UserMapper;
import com.yetao.blog.entity.User;
import com.yetao.blog.result.Message;
import com.yetao.blog.service.UserService;
import com.yetao.blog.util.IpUtil;
import com.yetao.blog.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yetao
 * @Date 2020/9/16 11:15
 * @Description 管理员service
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean initAdmin(User user, HttpServletRequest request) {
        if (userMapper.init() > 0) {
            return false;
        }
        user.setPassword(Md5Util.md5(user.getPassword()));
        user.setRole("管理员");
        user.setRegIp(IpUtil.getIpAddress(request));
        user.setLoginIp(IpUtil.getIpAddress(request));
        user.setState(Message.DEFAULT_STATE);
        //生成token todo
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean login(String username, String password, String captchaKey, String captchaValue, HttpServletRequest request, HttpServletResponse response) {
        User loginUser = userMapper.login(username, password);
        return loginUser != null;
    }

    @Override
    public User getAdminInfo(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean updateAdminInfo(User user) {
        return userMapper.updateById(user) > 0;
    }

}
