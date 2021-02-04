package com.yetao.blog.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yetao
 * @Date 2020/9/21 17:02
 * @Description mp分页插件
 */
@Configuration
@MapperScan("com.yetao.blog.mapper*")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor innerInterceptor = new PaginationInterceptor();
        innerInterceptor.setDbType(DbType.MYSQL);
        return innerInterceptor;
    }
}
