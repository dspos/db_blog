package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:21
 * @Description 文章分类
 */
@Data
@TableName("tb_category")
public class Category {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    private String pinyin;

    private String image;

    private String description;

    private Integer orders;

    private String state;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
