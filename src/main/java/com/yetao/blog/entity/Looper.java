package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:50
 * @Description 轮播图
 */
@Data
@TableName("tb_looper")
public class Looper {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String title;

    private Integer order;

    private String targetUrl;

    private String imageUrl;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
