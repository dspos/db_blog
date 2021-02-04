package com.yetao.blog;

import com.yetao.blog.mapper.CategoryMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author yetao
 * @Date 2020/10/29 10:07
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private CategoryMapper categoryMapper;


}
