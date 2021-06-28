package com.bearomance.helloworld.util;

import com.bearomance.helloworld.model.entity.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void test() {
//        redisTemplate.opsForValue().set("key1", "values1");
        Test test = new Test();
        test.setId(88);
        test.setDescription("88");
        redisTemplate.opsForValue().set("key2", test);
        redisTemplate.opsForList();

        Test key2 = (Test) redisTemplate.opsForValue().get("key2");
        System.out.println("?");
    }
}
