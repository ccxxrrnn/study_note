package com.xw.springboot.controller;

import com.xw.springboot.bean.person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloCon {
    @Autowired
    private person p;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("ser")
    public void testHelloService(){
        boolean b=applicationContext.containsBean("helloService");
        System.out.println(b);
    }


    @RequestMapping("/hello")
    public person Hello(){
        return p;
    }



}
