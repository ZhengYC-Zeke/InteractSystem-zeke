package com.zyc.is.controller;

import com.zyc.is.entity.Project;
import com.zyc.is.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.controller
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 15:28
 */
@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //查询所有
    @GetMapping("selectAll")
    public List<Project> selectAll(){
        return projectService.selectAll();
    }

    //根据教师查询
    @GetMapping("selectByTeacherId/{teacherId}")
    public List<Project> selectByTeacherId(@PathVariable String teacherId){
        return projectService.selectByTeacherId(teacherId);
    }

}
