package com.zyc.is.controller;

import com.zyc.is.entity.Knowledge;
import com.zyc.is.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.controller
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 10:14
 */
@RestController
@RequestMapping("knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    //根据课程查询
    @GetMapping("selectByProjectId/{projectId}")
    public List<Knowledge> selectByProjectId(@PathVariable String projectId){
        return knowledgeService.selectByProjectId(projectId);
    }

    //添加
    @PutMapping("add")
    public void add(@RequestBody Knowledge knowledge){
        knowledgeService.add(knowledge);
    }

}
