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
 * @Description: 文章实体类
 * @author: Zeke
 * @date: 2020/3/1 13:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "article")
public class Article implements Serializable {

    @Id
    //文章id
    private String id;
    //文章名称
    private String title;
    @Column(name = "teacherId")
    //教师id
    private String teacherId;
    //作者教师名称
    @Column(name = "teacherName")
    private String teacherName;
    //文章大体介绍
    private String presentation;
    //文章内容
    private String content;
    //创建日期
    @Column(name = "createDate")
    private Date createDate;

}
