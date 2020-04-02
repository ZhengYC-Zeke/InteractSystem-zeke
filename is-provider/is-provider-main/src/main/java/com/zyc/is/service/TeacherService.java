package com.zyc.is.service;

import com.zyc.is.entity.Article;
import com.zyc.is.entity.Teacher;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 10:31
 */
public interface TeacherService {

    //登录
    Teacher login(String username , String password);
    //jqgrid查询所有教师
    List<Teacher> selectAll(int page);
    //ajax查询所有教师
    List<Teacher> selectAll();
    //查询总数据量
    Integer selectAllSum();
    //根据6名老师
    List<Teacher> selectSixTeacher();
    //根据id查询
    Teacher selectById(String id);
    //根据用户名查询
    Teacher selectByUsername(String username);

}
