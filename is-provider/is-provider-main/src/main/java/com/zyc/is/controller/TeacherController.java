package com.zyc.is.controller;

import com.zyc.is.entity.Article;
import com.zyc.is.entity.Teacher;
import com.zyc.is.service.ArticleService;
import com.zyc.is.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //分页查询所有
    @RequestMapping("selectAllByPage")
    public Map<String,Object> selectByPage(int page) {
        //创建返回值map
        Map<String,Object> map = new HashMap<>();
        //分页查询所有
        map.put("rows",teacherService.selectAll(page));
        //放入当前页码
        map.put("page",page);
        //判断总页码
        map.put("total",teacherService.selectAllSum()% 6 == 0 ?teacherService.selectAllSum()/6:teacherService.selectAllSum()/6+1);
        return map;
    }

    @GetMapping("login")
    public Teacher login(String username , String password){
        Teacher teacher = teacherService.login(username, password);
        if(teacher==null)
            return new Teacher().setId("失败：请检查账户信息");
        else
            return teacher;
    }

    //查询所有教师
    @GetMapping("selectAll")
    public List<Teacher> selectAll(){
        return teacherService.selectAll();
    }

}
