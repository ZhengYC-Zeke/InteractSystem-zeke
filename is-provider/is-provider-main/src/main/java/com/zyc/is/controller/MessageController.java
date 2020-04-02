package com.zyc.is.controller;

import com.zyc.is.entity.Message;
import com.zyc.is.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.controller
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 12:51
 */
@Controller
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //分页查询所有
    @RequestMapping("selectAllByPage")
    @ResponseBody
    public Map<String,Object> selectByPage(int page) {
        //创建返回值map
        Map<String,Object> map = new HashMap<>();
        //分页查询所有
        map.put("rows",messageService.selectByPage(page));
        //放入当前页码
        map.put("page",page);
        //判断总页码
        map.put("total",messageService.selectAllSum()% 6 == 0 ?messageService.selectAllSum()/6:messageService.selectAllSum()/6+1);
        return map;
    }

    //添加
    @RequestMapping("add")
    public String add(Message message){
        messageService.add(message);
        return "redirect:/static/student/allTeacher.html";
    }

    //根据学生查询已回复的互动
    @GetMapping("selectByStuAndStateIsHave/{studentId}")
    public List<Message> selectByStuAndStateIsHave(@PathVariable String studentId){
       return messageService.selectByStuAndStateIsHave(studentId);
    }

    //根据学生查询未回复的互动
    @GetMapping("selectByStuAndStateIsNo/{studentId}")
    public List<Message> selectByStuAndStateIsNo(@PathVariable String studentId){
        return messageService.selectByStuAndStateIsNo(studentId);
    }

    //根据教师查询未回复的互动
    @GetMapping("selectByTeaAndStateIsNo/{teacherId}")
    public List<Message> selectByTeaAndStateIsNo(@PathVariable String teacherId){
        return messageService.selectByTeaAndStateIsNo(teacherId);
    }

    //教师回答
    @RequestMapping("answer")
    public String update(Message message){
        messageService.update(message);
        return "redirect:/static/teacher/allInteract.html";
    }

    //教师根据id查询单个互动
    @RequestMapping("selectById")
    public String selectById(@RequestParam String id , HttpServletRequest request){
        Message message = messageService.selectById(id);
        request.setAttribute("message",message);
        return "static/teacher/interactDetail";
    }

    //查看互动
    @RequestMapping("show")
    public String show(@RequestParam String id , HttpServletRequest request){
        Message message = messageService.selectById(id);
        request.setAttribute("message",message);
        return "static/student/interactShow";
    }

}
