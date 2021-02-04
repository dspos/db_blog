package com.yetao.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yetao.blog.entity.User;

/**
 * @Author yetao
 * @Date 2020/9/12 15:50
 * @Description 管理员mapper
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 判断user表中是否存在数据
     * @return
     */
    int init();

    /**
     * 管理员登录
     * @param username
     * @param password
     */
    User login(String username, String password);
}