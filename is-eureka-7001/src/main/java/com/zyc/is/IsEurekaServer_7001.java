package com.zyc.is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/1 13:01
 */
@SpringBootApplication
@EnableEurekaServer
public class IsEurekaServer_7001 {

    public static void main(String[] args) {

        SpringApplication.run(IsEurekaServer_7001.class , args);

    }

}
