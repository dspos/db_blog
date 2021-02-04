package com.yetao.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/9/11 14:05
 * @Description 文章
 */

@Data
@TableName("tb_article")
@ApiModel("文章")
public class Article {

    @ApiModelProperty("id")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("分类id")
    private String categoryId;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("类型（0表示富文本，1表示markdown）")
    private String type;

    @ApiModelProperty("状态（0表示已发布，1表示草稿，2表示删除）")
    private String state;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("阅读数量")
    private Integer view;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
