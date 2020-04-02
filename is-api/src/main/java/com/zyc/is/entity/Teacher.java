package com.zyc.is.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.entity
 * @Description: 教师实体类
 * @author: Zeke
 * @date: 2020/3/1 13:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "teacher")
public class Teacher implements Serializable {

    //编号
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
    //学院
    private String college;
    //电话
    private String phone;

    //课程和回答数量
    private Map<Project , Integer> map;

}
