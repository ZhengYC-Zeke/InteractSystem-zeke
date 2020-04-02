package com.zyc.is.service;

import com.zyc.is.entity.Article;
import com.zyc.is.entity.Message;
import com.zyc.is.mapper.MessageMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.service
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 12:31
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> selectByPage(int page) {
        RowBounds rowBuouds = new RowBounds((page-1)*6,6);
        return messageMapper.selectByRowBounds(new Message(),rowBuouds);
    }

    @Override
    public Integer selectAllSum() {
        return messageMapper.selectCount(new Message());
    }

    @Override
    public void add(Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setState("未回复");
        message.setCreateDate(new Date());
        messageMapper.insert(message);
    }

    @Override
    public List<Message> selectByStuAndStateIsHave(String studentId) {
        return messageMapper.select(new Message().setState("已回复").setStudentId(studentId));
    }

    @Override
    public List<Message> selectByStuAndStateIsNo(String studentId) {
        return messageMapper.select(new Message().setState("未回复").setStudentId(studentId));
    }

    @Override
    public List<Message> selectByTeaAndStateIsNo(String teacherId) {
        return messageMapper.select(new Message().setState("未回复").setTeacherId(teacherId));
    }

    @Override
    public void update(Message message) {
        messageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public Message selectById(String id) {
        return messageMapper.selectOne(new Message().setId(id));
    }

    @Override
    public List<Message> selectFourteen() {
        RowBounds rowBounds = new RowBounds(0,14);
        List<Message> messages = messageMapper.selectByRowBounds(new Message(), rowBounds);
        return messages;
    }

    @Override
    public Integer selectCountByProject(String projectId) {
        return messageMapper.selectCount(new Message().setProjectId(projectId));
    }
}
