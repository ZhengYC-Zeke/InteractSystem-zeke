package com.zyc.is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ProjectName: InteractSystem
 * @Package com.zyc.is
 * @Description: 类的描述
 * @author: Zeke
 * @date: 2020/3/8 15:02
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.zyc.is.mapper")
public class Provider_Main_8001 {

    public static void main(String[] args) {

        SpringApplication.run(Provider_Main_8001.class , args);

    }

}
