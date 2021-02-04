package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:42
 * @Description 图片
 */
@Data
@TableName("tb_image")
public class Image {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String userId;

    private String url;

    private String state;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
