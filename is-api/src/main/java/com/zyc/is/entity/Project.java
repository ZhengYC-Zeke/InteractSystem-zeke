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
 * @Description: 课程实体类
 * @author: Zeke
 * @date: 2020/3/1 13:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "project")
public class Project implements Serializable {

    //id
    @Id
    private String id;
    //课程名称
    private String name;
    //上课地点
    private String place;
    //任课教师id
    @Column(name = "teacherId")
    private String teacherId;
    //创建时间
    @Column(name = "createDate")
    private Date createDate;

}
