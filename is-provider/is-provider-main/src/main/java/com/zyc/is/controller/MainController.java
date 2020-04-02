package com.zyc.is.controller;

import com.netflix.discovery.converters.Auto;
import com.zyc.is.entity.Article;
import com.zyc.is.entity.Message;
import com.zyc.is.entity.Project;
import com.zyc.is.entity.Teacher;
import com.zyc.is.service.ArticleService;
import com.zyc.is.service.MessageService;
import com.zyc.is.service.ProjectService;
import com.zyc.is.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.controller
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 12:19
 */
@Controller
@RequestMapping("main")
public class MainController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("first")
    public String firstPage(HttpServletRequest request) {
        //获取课程
        List<Project> projects = projectService.selectSevenByCreateDate();
        //根据课程查询教师
        Iterator<Project> iterator1 = projects.iterator();
        while (iterator1.hasNext()) {
            //获取课程
            Project project = iterator1.next();
            //获取教师
            Teacher teacher = teacherService.selectById(project.getTeacherId());
            //替换为教师姓名
            project.setTeacherId(teacher.getName());
        }
        //获取文章
        List<Article> articles = articleService.selectFourByCreateDate();
        //获取互动
        List<Message> messages = messageService.selectFourteen();
        //获取教师
        List<Teacher> teachers = teacherService.selectSixTeacher();
        //根据教师获取课程
        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            Map<Project, Integer> map = new HashMap<>();
            //获取课程
            List<Project> list = projectService.selectByTeacherId(teacher.getId());
            for (Project project : list) {
                //获取每个课程的回答数量
                Integer count = messageService.selectCountByProject(project.getId());
                map.put(project, count);
            }
            teacher.setMap(map);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("projects", projects);
        map.put("messages", messages);
        map.put("articles", articles);
        map.put("teachers", teachers);
        request.setAttribute("map", map);
        return "static/main";
    }

    //登录
    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request) {
        //获得主体信息
        Subject subject = SecurityUtils.getSubject();
        //创建用户名和密码的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录
        try {
            subject.login(token);
            return "redirect:/main/first";
        } catch (UnknownAccountException e) {
            request.setAttribute("msg", "账户不存在");
            return "static/login/login";
        } catch (IncorrectCredentialsException e) {
            request.setAttribute("msg", "密码错误");
            return "static/login/login";
        }
    }

}
