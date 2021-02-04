package com.yetao.blog.service;

import com.yetao.blog.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yetao
 * @Date 2020/9/16 11:14
 * @Description 管理员service
 */

public interface UserService {

    /**
     * 初始化管理员信息
     * @param user
     * @param request
     */
    boolean initAdmin(User user, HttpServletRequest request);

    /**
     * 管理员登录
     * @param username
     * @param password
     * @param captchaKey
     * @param captchaValue
     * @param request
     * @param response
     */
    boolean login(String username, String password, String captchaKey, String captchaValue, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取管理员信息
     * @param id
     * @return
     */
    User getAdminInfo(String id);

    /**
     * 修改管理员信息
     * @param user
     * @return
     */
    boolean updateAdminInfo(User user);
}
