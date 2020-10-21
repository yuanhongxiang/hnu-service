package com.hnu.control;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nacosCont")
@Api("nacos操作")
@RefreshScope
public class NacosControl {

    private static final Logger log = LoggerFactory.getLogger(NacosControl.class);

    @Value("${user.name.yuan}")
    private String username;

    @Value("${user.pwd}")
    private String pwd;

    @Value("${swagger.enabled}")
    private String swaggerAble ;



    @ApiOperation("测试nacos")
    @GetMapping(value = "testNacos")
    public String testNacos(){
        String result = "username :"+username+";  pwd :"+pwd+";   swaggerAble :"+swaggerAble;
        log.info("result:"+ result);
        return "test Nacos  :" + result;
    }

}
