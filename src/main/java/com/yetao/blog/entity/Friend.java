package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:40
 * @Description 友链
 */

@Data
@TableName("tb_friend")
public class Friend {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    private String logo;

    private String url;

    private Integer order;

    private String state;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
