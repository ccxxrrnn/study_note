package com.XW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 标志一个主程序，这是一个spring boot 应用·
 */
@SpringBootApplication
public class HelloWordMainApplication {
    public static void main(String[] args) {
        //Spring 应用启动
        SpringApplication.run(HelloWordMainApplication.class,args);
    }
}
