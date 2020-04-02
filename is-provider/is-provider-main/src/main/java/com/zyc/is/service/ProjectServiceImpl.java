package com.zyc.is.service;

import com.zyc.is.entity.Project;
import com.zyc.is.mapper.ProjectMapper;
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
 * @date: 2020/3/10 15:26
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> selectAll() {
        return projectMapper.selectAll();
    }

    @Override
    public List<Project> selectByTeacherId(String teacherId) {
        return projectMapper.select(new Project().setTeacherId(teacherId));
    }

    @Override
    public List<Project> selectSevenByCreateDate() {
        Example example = new Example(Project.class);
        example.orderBy("createDate").desc();
        RowBounds rowBounds = new RowBounds(0,7);
        List<Project> projects = projectMapper.selectByExampleAndRowBounds(example, rowBounds);
        return projects;
    }
}
