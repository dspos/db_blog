package com.yetao.blog.web.admin;

import com.yetao.blog.entity.Category;
import com.yetao.blog.result.Message;
import com.yetao.blog.result.ResponseResult;
import com.yetao.blog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yetao
 * @Date 2020/9/18 16:52
 * @Description 分类接口
 */
@RestController
@RequestMapping("admin/category")
@Api(tags = "文章分类接口")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("添加分类")
    @PostMapping("add")
    public ResponseResult addCategory(@RequestBody Category category) {
        if (StringUtils.isEmpty(category.getName()) && StringUtils.isEmpty(category.getPinyin())) {
            return ResponseResult.failed("分类名称和拼音不能为空");
        }
        if (!categoryService.addCategory(category)) {
            return ResponseResult.failed(Message.INSERT_FAILED);
        }
        return ResponseResult.success(Message.INSERT_FAILED);
    }

    @ApiOperation("修改分类")
    @PutMapping("update")
    public ResponseResult updateCategory(@RequestBody Category category) {
        if (!categoryService.updateCategory(category)) {
            return ResponseResult.failed(Message.UPDATE_FAILED);
        }
        return ResponseResult.success(Message.UPDATE_SUCCESS);
    }

    @ApiOperation("根据id批量删除")
    @DeleteMapping("delete")
    public ResponseResult deleteCategoryByIds(@RequestBody List<String> catIds) {
        if (!categoryService.deleteCategoryByIds(catIds)) {
            return ResponseResult.failed(Message.DELETE_FAILED);
        }
        return ResponseResult.success(Message.DELETE_SUCCESS);
    }

    @ApiOperation("分类信息")
    @GetMapping("{id}")
    public ResponseResult getCategory(@PathVariable("id") String id) {
        Category category = categoryService.getCategory(id);
        return ResponseResult.success(Message.SELECT_SUCCESS, category);
    }

    @ApiOperation("分类列表")
    @GetMapping("list")
    public ResponseResult getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        return ResponseResult.success(Message.SELECT_SUCCESS, categoryList);
    }

    @ApiOperation("分类分页列表")
    @GetMapping("list/{page}/{size}")
    public ResponseResult getCategoryPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        List<Category> categoryList = categoryService.getCategoryPage(page, size);
        return ResponseResult.success(Message.SELECT_SUCCESS, categoryList);
    }
}
