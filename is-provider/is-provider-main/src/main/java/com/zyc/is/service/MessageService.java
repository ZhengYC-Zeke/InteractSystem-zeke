package com.zyc.is.service;

import com.zyc.is.entity.Message;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 12:24
 */
public interface MessageService {

    //jqgrid查询所有
    List<Message> selectByPage(int page);

    //查询总数
    Integer selectAllSum();

    //添加
    void add(Message message);

    //根据学生查询已回复的互动
    List<Message> selectByStuAndStateIsHave(String studentId);

    //根据学生查询未回复的互动
    List<Message> selectByStuAndStateIsNo(String studentId);

    //根据教师查询未回复的互动
    List<Message> selectByTeaAndStateIsNo(String teacherId);

    //修改
    void update(Message message);

    //根据id查询单个互动
    Message selectById(String id);

    //查询14条数据
    List<Message> selectFourteen();

    //根据课程获取回答数量
    Integer selectCountByProject(String projectId);

}
