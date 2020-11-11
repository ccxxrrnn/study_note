package com.xw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiongwei
 * @WriteTime 2020-11-10 15:40
 */

@RestController
@Slf4j
@RefreshScope   // 在SpringBoot 2.0以上默认使用Hikari连接池，一旦连接池启动，就无法再修改HikariDataSource，所以刷新配置时连带数据源一起刷新，于是会报错。
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        log.info(configInfo);
        return configInfo;
    }
}
