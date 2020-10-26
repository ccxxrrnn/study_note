package com.xw.springboot.config;


import com.xw.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:指明当前类是配置类；用来替代了之前的Spring配合文件
 * 在配置文件里用<bean><bean/>标签来添加组件
 *
 */
@Configuration
public class MyAppConfig {

    //将方法返回值添加到容器里面，容器中组件的，默认id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器添加了组件。。。");
        return new HelloService();
    }
}
