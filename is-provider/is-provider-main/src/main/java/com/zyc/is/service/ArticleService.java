package com.zyc.is.service;

import com.zyc.is.entity.Article;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 16:08
 */
public interface ArticleService {

    //根据教师查询7篇文章
    List<Article> selectSevenByTeacherId(String teacherId);
    //添加文章
    void add(Article article);
    //删除文章
    void delete(String id);
    //根据时间查询4篇文章
    List<Article> selectFourByCreateDate();
    //分页查询所有
    List<Article> selectByPage(int page);
    //查询总数据量
    Integer selectAllSum();

}
