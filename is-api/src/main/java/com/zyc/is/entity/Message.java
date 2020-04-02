package com.zyc.is.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.entity
 * @Description: 互动实体类
 * @author: Zeke
 * @date: 2020/3/1 13:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "message")
public class Message implements Serializable {

    //id
    @Id
    private String id;
    //互动名称
    private String name;
    //创建日期
    @Column(name = "createDate")
    private Date createDate;
    //询问教师姓名
    @Column(name = "teacherName")
    private String teacherName;
    //教师id
    @Column(name = "teacherId")
    private String teacherId;
    //学生姓名
    @Column(name = "studentName")
    private String studentName;
    //学生id
    @Column(name = "studentId")
    private String studentId;
    //提问详情
    @Column(name = "stuContent")
    private String stuContent;
    //教师回答
    @Column(name = "teaContent")
    private String teaContent;
    //所属课程id
    @Column(name = "projectId")
    private String projectId;
    //所属课程名称
    @Column(name = "projectName")
    private String projectName;
    //状态
    private String state;
    //知识点
    private String knowledge;

}
