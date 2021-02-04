package com.yetao.blog.service;

import com.yetao.blog.entity.Category;

import java.util.List;

/**
 * @Author yetao
 * @Date 2020/9/18 16:56
 * @Description 分类service
 */

public interface CategoryService {

    /**
     * 添加分类
     * @param category
     */
    boolean addCategory(Category category);

    /**
     * 更新分类
     * @param category
     */
    boolean updateCategory(Category category);

    /**
     * 删除分类
     * @param id
     */
    boolean deleteCategory(String id);

    /**
     * 根据id查询分类
     * @param id
     */
    Category getCategory(String id);

    /**
     * 查询分类列表
     */
    List<Category> getCategoryList();

    /**
     * 分页查询
     * @param page
     * @param size
     */
    List<Category> getCategoryPage(int page, int size);

    /**
     * 根据id批量删除
     * @param catIds
     * @return
     */
    boolean deleteCategoryByIds(List<String> catIds);
}
