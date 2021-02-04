package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:32
 * @Description 每日访问量
 */

@Data
@TableName("tb_daily_view")
public class DailyView {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private Integer viewCount;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
