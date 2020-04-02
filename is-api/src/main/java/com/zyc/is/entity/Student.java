package com.zyc.is.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.entity
 * @Description: 学生实体类
 * @author: Zeke
 * @date: 2020/3/1 13:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "student")
public class Student implements Serializable {

    //id
    @Id
    private String id;
    //用户名
    private String username;
    //密码
    private String password;
    //姓名
    private String name;
    //性别
    private String sex;
    //所属班级
    private String grade;
    //所属学院
    private String college;
    //电话
    private String phone;
    //职位
    private String position;

}
