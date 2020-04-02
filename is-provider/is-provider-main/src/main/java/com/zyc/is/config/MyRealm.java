package com.zyc.is.config;

import com.netflix.discovery.converters.Auto;
import com.zyc.is.entity.Student;
import com.zyc.is.entity.Teacher;
import com.zyc.is.service.StudentService;
import com.zyc.is.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.config
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 17:25
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取token
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //获取用户名
        String username = token.getUsername();
        //判断是教师还是学生
        if(username.startsWith("1")){
            //学生
            //查询
            Student student = studentService.selectByUsername(username);
            if(student == null)
                return null;
            else
                return new SimpleAuthenticationInfo(student , student.getPassword() , "");
        }else if (username.startsWith("2")){
            //教师
            //查询
            Teacher teacher = teacherService.selectByUsername(username);
            if(teacher == null)
                return null;
            else
                return new SimpleAuthenticationInfo(teacher , teacher.getPassword() , "");
        }else {
            return null;
        }
    }
}
