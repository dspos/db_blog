package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:55
 * @Description 设置
 */
@Data
@TableName("tb_setting")
public class Setting {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String key;
    
    private String value;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
