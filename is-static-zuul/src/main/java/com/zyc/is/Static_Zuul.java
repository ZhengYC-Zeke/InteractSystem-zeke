package com.zyc.is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 14:58
 */
@SpringBootApplication
@EnableZuulProxy
public class Static_Zuul {

    public static void main(String[] args) {

        SpringApplication.run(Static_Zuul.class , args);

    }

}
