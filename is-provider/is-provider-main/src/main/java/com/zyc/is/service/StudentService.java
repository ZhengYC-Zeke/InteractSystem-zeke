package com.zyc.is.service;

import com.zyc.is.entity.Student;
import com.zyc.is.entity.Teacher;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 11:07
 */
public interface StudentService {

    //登录
    Student login(String username , String password);
    //jqgrid查询所有学生
    List<Student> selectAll(int page);
    //查询总数据量
    Integer selectAllSum();
    //根据用户名查询
    Student selectByUsername(String username);

}
