package com.yetao.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yetao.blog.mapper.CategoryMapper;
import com.yetao.blog.entity.Category;
import com.yetao.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yetao
 * @Date 2020/9/18 16:56
 * @Description 分类service
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean addCategory(Category category) {
        category.setOrders(1);
        category.setState("1");
        return categoryMapper.insert(category) > 0;
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryMapper.updateById(category) > 0;
    }

    @Override
    public boolean deleteCategory(String id) {
        return true;
    }

    @Override
    public Category getCategory(String id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.selectList(null);
    }

    @Override
    public List<Category> getCategoryPage(int page, int size) {
        IPage<Category> categoryPage = new Page<>(page, size);
        categoryPage = categoryMapper.selectPage(categoryPage, null);
        return categoryPage.getRecords();
    }

    @Override
    public boolean deleteCategoryByIds(List<String> catIds) {
        return categoryMapper.deleteBatchIds(catIds) > 0;
    }
}
