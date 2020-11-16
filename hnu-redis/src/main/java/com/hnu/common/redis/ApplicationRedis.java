package com.hnu.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ApplicationRedis {

    @Autowired
    private  RedisUtils redisUtils;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRedis.class);
    }

    @PostConstruct
    public void get(){
        System.out.println("yuanhx: "+redisUtils.get("yuanhx"));
        redisUtils.set("1111", "1111");
        redisUtils.set("yuanhx", "袁红祥");
        redisUtils.del("ab");


    }

}
