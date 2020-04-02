package com.zyc.is.config;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is.config
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/10 17:59
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean
    shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //创建拦截资源的集合
        Map<String , String> map = new LinkedHashMap<>();
        //公共资源，不拦截
        map.put("/main/login","anon");
        map.put("/**/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //设置拦截后跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/static/login/login.jsp");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

}
