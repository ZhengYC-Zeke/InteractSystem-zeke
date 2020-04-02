package com.zyc.is.mapper;

import com.zyc.is.entity.Message;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.mapper
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 12:23
 */
@Repository
public interface MessageMapper extends Mapper<Message> {
}
