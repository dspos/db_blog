package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:23
 * @Description 评论
 */
@Data
@TableName("tb_comment")
public class Comment {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String parentContent;

    private String articleId;

    private String content;

    private String userId;

    private String userAvatar;

    private String username;

    private String state;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
