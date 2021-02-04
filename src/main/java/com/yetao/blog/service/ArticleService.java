package com.yetao.blog.service;

import com.yetao.blog.entity.Article;

import java.util.List;

/**
 * @Author yetao
 * @Date 2020/9/21 18:48
 * @Description 文章service
 */

public interface ArticleService {

    /**
     * 添加文章
     * @param article
     */
    boolean addArticle(Article article);

    /**
     * 更新文章
     * @param article
     */
    boolean updateArticle(Article article);

    /**
     * 删除文章
     * @param id
     */
    boolean deleteArticle(String id);

    /**
     * 查询文章
     * @param id
     */
    Article getArticleInfo(String id);

    /**
     * 查询文章列表
     */
    List<Article> getArticleList();

    /**
     * 分页查询文章列表
     * @param page
     * @param size
     */
    List<Article> getArticlePage(int page, int size);

    boolean deleteArticleByIds(List<String> catIds);
}
