package com.yetao.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yetao.blog.mapper.ArticleMapper;
import com.yetao.blog.mapper.CategoryMapper;
import com.yetao.blog.entity.Article;
import com.yetao.blog.entity.Category;
import com.yetao.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yetao
 * @Date 2020/9/21 18:49
 * @Description 文章service
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean addArticle(Article article) {
        if (haveCategory(article)) {
            return false;
        }
        article.setState("1");
        return articleMapper.insert(article) > 0;
    }

    @Override
    public boolean updateArticle(Article article) {
        if (haveCategory(article)) {
            return false;
        }
        return articleMapper.updateById(article) > 0;
    }

    @Override
    public boolean deleteArticle(String id) {
        return articleMapper.deleteById(id) > 0;
    }

    @Override
    public boolean deleteArticleByIds(List<String> catIds) {
        return articleMapper.deleteBatchIds(catIds) > 0;
    }

    @Override
    public Article getArticleInfo(String id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Article> getArticleList() {
        return articleMapper.selectList(null);
    }

    @Override
    public List<Article> getArticlePage(int page, int size) {
        IPage<Article> articlePage = new Page<>(page, size);
        articlePage = articleMapper.selectPage(articlePage, null);
        return articlePage.getRecords();
    }

    /**
     * 判断文章所选的分类是否正确
     * @param article
     * @return
     */
    private boolean haveCategory(Article article) {
        List<Category> categoryList = categoryMapper.selectList(null);
        Map<String, String> map = new HashMap<>(2);
        for (Category category : categoryList) {
            map.put(category.getId(), category.getName());
        }
        return !map.containsKey(article.getCategoryId());
    }
}
