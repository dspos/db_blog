package com.yetao.blog.web.admin;

import com.yetao.blog.entity.Article;
import com.yetao.blog.result.ResponseResult;
import com.yetao.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yetao
 * @Date 2020/9/21 18:46
 * @Description 文章接口
 */
@RestController
@RequestMapping("admin/article")
@Api(tags = "文章管理接口")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("添加文章")
    @PostMapping("add")
    public ResponseResult addArticle(@RequestBody Article article) {
        if (!articleService.addArticle(article)) {
            return ResponseResult.failed("修改失败");
        }
        return ResponseResult.success("修改成功");
    }

    @ApiOperation("修改文章")
    @PutMapping("update")
    public ResponseResult updateArticle(@RequestBody Article article) {
        if (!articleService.updateArticle(article)) {
            return ResponseResult.failed("修改失败");
        }
        return ResponseResult.success("修改成功");
    }

    @ApiOperation("删除文章")
    @DeleteMapping("delete/{id}")
    public ResponseResult deleteArticle(@PathVariable("id") String id) {
        if (!articleService.deleteArticle(id)) {
            return ResponseResult.failed("删除失败");
        }
        return ResponseResult.success("删除成功");
    }

    @ApiOperation("根据id批量删除")
    @DeleteMapping("delete")
    public ResponseResult deleteArticleByIds(@RequestBody List<String> catIds) {
        if (!articleService.deleteArticleByIds(catIds)) {
            return ResponseResult.failed("删除失败");
        }
        return ResponseResult.success("删除成功");
    }

    @ApiOperation("文章信息")
    @GetMapping("info/{id}")
    public ResponseResult getArticle(@PathVariable("id") String id) {
        Article article = articleService.getArticleInfo(id);
        return ResponseResult.success("获取文章信息成功", article);
    }

    @ApiOperation("文章列表")
    @GetMapping("list")
    public ResponseResult getArticleList() {
        List<Article> articleList = articleService.getArticleList();
        return ResponseResult.success("查询文章列表成功", articleList);
    }

    @ApiOperation("文章分页列表")
    @GetMapping("list/{page}/{size}")
    public ResponseResult getArticlePage(@PathVariable("page") int page, @PathVariable("size") int size) {
        List<Article> articlePageList = articleService.getArticlePage(page, size);
        return ResponseResult.success("分页查询文章列表成功", articlePageList);
    }
}
