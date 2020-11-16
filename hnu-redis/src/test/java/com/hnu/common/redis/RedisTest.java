package com.hnu.common.redis;

import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRedis.class)
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Before
    public void init(){
        System.out.println(" begin init redis....");
    }

    @Test
    public void testSet(){
        System.out.println(redisUtils.get("1111"));
        redisUtils.del("ab");

        User user = new User();
        user.setName("yuan");
        user.setUserName("yhx");

        redisUtils.set("objyuanhx", user);

        redisTemplate.opsForValue().get("objyuanhx");
        System.out.println("redisTemplate.opsForValue().get(\"objyuanhx\"):  "+ redisTemplate.opsForValue().get("objyuanhx"));
        User user1 = (User) redisUtils.get("objyuanhx");
        System.out.println(user1);



        System.out.println("----------------------");
        List<User> users = new ArrayList();
        Map map = new HashMap();
        List list11 = new ArrayList();
        for(int i = 0; i < 100000; i++){
            Map map1 = new HashMap();
            User user2 = new User();
            user2.setName("yuanhx"+i+1);
            user2.setUserName("yuanhx"+i+1);
            users.add(user2);
//            map1.put("hnu:map:test:"+i, user2);
            list11.add("hnu:map:test:"+i);
            map.put("hnu:map:test:"+i, user2);
        }
//        map.put("hnu:map:test:1", users);
//        map.put("hnu:map:test:2", users);
//        map.put("hnu:map:test:3", users);
        long begin = System.currentTimeMillis();
        redisTemplate.opsForValue().multiSet(map);
        long end = System.currentTimeMillis() - begin;
        System.out.println("end : "+end);


        List resultList = redisTemplate.opsForValue().multiGet(list11);

        long end1 = System.currentTimeMillis() - begin;
        System.out.println("end1 :"+end1 + "   resultSize:"+ resultList.size());

    }

    public void batchInsertRedis(final List<User> users){
        redisTemplate.executePipelined(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (User user: users.subList(0,1000)){
                    String key = "hnu:map:test:"+user.getName();
//                    redisConnection.hSet(key.getBytes(), user.getName().getBytes(), );
                }
                return null;
            }
        });


//        Cursor cursor = redisTemplate.opsForHash().scan("hnu:map:test")
    }


}
