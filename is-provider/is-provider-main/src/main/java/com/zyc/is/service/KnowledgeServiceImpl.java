package com.zyc.is.service;

import com.zyc.is.entity.Knowledge;
import com.zyc.is.mapper.KnowledgeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 10:13
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Override
    public List<Knowledge> selectByProjectId(String projectId) {
        return knowledgeMapper.select(new Knowledge().setProjectId(projectId));
    }

    @Override
    public void add(Knowledge knowledge) {
        knowledgeMapper.insert(knowledge);
    }
}
