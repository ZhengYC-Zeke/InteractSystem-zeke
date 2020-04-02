package com.zyc.is.mapper;

import com.zyc.is.entity.Article;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.mapper
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 16:07
 */
@Repository
public interface ArticleMapper extends Mapper<Article> {
}
