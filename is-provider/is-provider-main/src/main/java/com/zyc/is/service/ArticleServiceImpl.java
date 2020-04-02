package com.zyc.is.service;

import com.zyc.is.entity.Article;
import com.zyc.is.mapper.ArticleMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 16:12
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectSevenByTeacherId(String teacherId) {
        RowBounds rowBounds = new RowBounds(0,7);
        List<Article> articles = articleMapper.selectByRowBounds(new Article().setTeacherId(teacherId), rowBounds);
        return articles;
    }

    @Override
    public void add(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void delete(String id) {
        articleMapper.delete(new Article().setId(id));
    }

    @Override
    public List<Article> selectFourByCreateDate() {
        Example example = new Example(Article.class);
        example.orderBy("createDate").desc();
        RowBounds rowBounds = new RowBounds(0,4);
        return articleMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public List<Article> selectByPage(int page) {
        RowBounds rowBuouds = new RowBounds((page-1)*6,6);
        return articleMapper.selectByRowBounds(new Article(),rowBuouds);
    }

    @Override
    public Integer selectAllSum() {
        return articleMapper.selectCount(new Article());
    }
}
