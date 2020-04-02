package com.zyc.is.mapper;

import com.zyc.is.entity.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.mapper
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 11:06
 */
@Repository
public interface StudentMapper extends Mapper<Student> {
}

