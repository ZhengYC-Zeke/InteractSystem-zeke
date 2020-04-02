package com.zyc.is.service;

import com.zyc.is.entity.Article;
import com.zyc.is.entity.Teacher;
import com.zyc.is.mapper.TeacherMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 10:39
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String username, String password) {
        return teacherMapper.selectOne(new Teacher().setUsername(username).setPassword(password));
    }

    @Override
    public List<Teacher> selectAll(int page) {
        RowBounds rowBuouds = new RowBounds((page-1)*6,6);
        return teacherMapper.selectByRowBounds(new Teacher(),rowBuouds);
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public Integer selectAllSum() {
        return teacherMapper.selectCount(new Teacher());
    }

    @Override
    public List<Teacher> selectSixTeacher() {
        RowBounds rowBounds = new RowBounds(0,6);
        List<Teacher> teachers = teacherMapper.selectByRowBounds(new Teacher(), rowBounds);
        return teachers;
    }

    @Override
    public Teacher selectById(String id) {
        return teacherMapper.selectOne(new Teacher().setId(id));
    }

    @Override
    public Teacher selectByUsername(String username) {
        return teacherMapper.selectOne(new Teacher().setUsername(username));
    }
}
