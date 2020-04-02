package com.zyc.is.service;

import com.zyc.is.entity.Student;
import com.zyc.is.entity.Teacher;
import com.zyc.is.mapper.StudentMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 11:14
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String username, String password) {
        return studentMapper.selectOne(new Student().setUsername(username).setPassword(password));
    }

    @Override
    public List<Student> selectAll(int page) {
        RowBounds rowBuouds = new RowBounds((page-1)*6,6);
        return studentMapper.selectByRowBounds(new Student(),rowBuouds);
    }

    @Override
    public Integer selectAllSum() {
        return studentMapper.selectCount(new Student());
    }

    @Override
    public Student selectByUsername(String username) {
        return studentMapper.selectOne(new Student().setUsername(username));
    }
}

