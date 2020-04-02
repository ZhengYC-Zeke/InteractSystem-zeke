package com.zyc.is.controller;

import com.zyc.is.entity.Student;
import com.zyc.is.entity.Teacher;
import com.zyc.is.service.StudentService;
import com.zyc.is.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.controller
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 16:17
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //分页查询所有
    @RequestMapping("selectAllByPage")
    public Map<String,Object> selectByPage(int page) {
        //创建返回值map
        Map<String,Object> map = new HashMap<>();
        //分页查询所有
        map.put("rows",studentService.selectAll(page));
        //放入当前页码
        map.put("page",page);
        //判断总页码
        map.put("total",studentService.selectAllSum()% 6 == 0 ?studentService.selectAllSum()/6:studentService.selectAllSum()/6+1);
        return map;
    }

    @GetMapping("login")
    public Student login(String username , String password){
        Student student = studentService.login(username, password);
        if(student==null)
            return new Student().setId("失败：请检查账户信息");
        else
            return student;
    }

}
