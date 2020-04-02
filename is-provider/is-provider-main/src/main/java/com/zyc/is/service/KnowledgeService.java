package com.zyc.is.service;

import com.zyc.is.entity.Knowledge;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 10:10
 */
public interface KnowledgeService {

    //根据课程查询
    List<Knowledge> selectByProjectId(String projectId);

    //添加
    void add(Knowledge knowledge);

}
