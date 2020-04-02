package com.zyc.is.controller;

import com.zyc.is.entity.Article;
import com.zyc.is.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.controller
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 16:17
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //根据教师查询7篇文章
    @GetMapping("selectSevenByTeacherId/{teacherId}")
    public List<Article> selectSevenByTeacherId(@PathVariable("teacherId") String teacherId) {
        return articleService.selectSevenByTeacherId(teacherId);
    }

    //添加文章
    @PutMapping("add")
    public void add(@RequestBody Article article) {
        articleService.add(article);
    }

    //删除文章
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") String id){
        articleService.delete(id);
    }

    //根据时间查询4篇文章
    @GetMapping("selectFourByCreateDate")
    public List<Article> selectFourByCreateDate() {
        return articleService.selectFourByCreateDate();
    }

    //分页查询所有
    @RequestMapping("selectAllByPage")
    public Map<String,Object> selectByPage(int page) {
        //创建返回值map
        Map<String,Object> map = new HashMap<>();
        //分页查询所有
        map.put("rows", articleService.selectByPage(page));
        //放入当前页码
        map.put("page",page);
        //判断总页码
        map.put("total",articleService.selectAllSum()% 6 == 0 ?articleService.selectAllSum()/6:articleService.selectAllSum()/6+1);
        return map;
    }


}
