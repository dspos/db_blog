package com.yetao.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author yetao
 * @Date 2020/9/11 15:50
 * @Description 启动类
 */
@SpringBootApplication
@MapperScan("com.yetao.blog.mapper")
public class DbBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbBlogApplication.class, args);
    }

}
