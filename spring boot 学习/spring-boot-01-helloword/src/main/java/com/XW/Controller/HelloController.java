package com.XW.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody  //写给浏览器
    @RequestMapping("/hello")
    public String Hello(){
        return "HelloWord!";
    }
}
