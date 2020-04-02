package com.zyc.is.service;

import com.zyc.is.entity.Project;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 13:55
 */
public interface ProjectService {

    //查询所有
    List<Project> selectAll();

    //根据教师查询
    List<Project> selectByTeacherId(String teacherId);

    //根据时间询7门课程
    List<Project> selectSevenByCreateDate();

}
