package com.bearomance.helloworld.service.impl;

import com.bearomance.helloworld.model.entity.Test;
import com.bearomance.helloworld.model.mapper.TestMapper;
import com.bearomance.helloworld.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xmj
 * @since 2021-06-25
 */
@Service
@CacheConfig(cacheNames = "ttt")
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {


    /**
     * 将结果缓存，当参数相同时，不会执行方法，从缓存中取
     * @param id
     * @return
     */
    @Override
    @Cacheable(key = "#id")
    public Test findByIdRedis(Integer id) {
        return this.getById(id);
    }

    /**
     * 将结果缓存，并且该方法不管缓存是否存在，每次都会执行
     * @param test
     * @return
     */
    @Override
    @CachePut(key="#test.id")
    public Test updateRedis(Test test) {
        this.updateById(test);
        return test;
    }

    /**
     * 移除缓存，根据指定key
     * @param id
     */
    @Override
    @CacheEvict(key = "#id")
    public void deleteByIdRedis(Integer id) {
        this.removeById(id);
        System.out.println("delete");
    }

    @CacheEvict(allEntries = true)
    public void deleteAll() {
        System.out.println("移除当前 cacheName下所有缓存");
    }

}
