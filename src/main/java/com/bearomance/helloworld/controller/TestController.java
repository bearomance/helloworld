package com.bearomance.helloworld.controller;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bearomance.helloworld.model.entity.Test;
import com.bearomance.helloworld.model.mapper.TestMapper;
import com.bearomance.helloworld.model.vo.TestVO;
import com.bearomance.helloworld.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    @Resource
    private TestMapper testMapper;

    @Resource
    private TestService testService;

    private AtomicInteger count = new AtomicInteger(0);

    @GetMapping("/t1")
    public String t1() {
        int i = count.getAndIncrement();
        return "t1 success: " + i;
    }

    @GetMapping("/t2")
    public String t2() {
        List<Test> tests = testMapper.selectList(null);
        Console.log(tests);//test

        List<TestVO> testVOS = testMapper.testVO();
        Console.log(testVOS);
        return "t2 success";
    }

    @GetMapping("/t3")
    public Page<Test> t3() {
        Page<Test> page = new Page<>(1, 1);
        Page<Test> page1 = testService.page(page);
        return page1;
    }

    @GetMapping("/t4")
    public Test t4(Integer id) {
        return testService.findByIdRedis(id);
    }

    @GetMapping("/t5")
    public void t5(Integer id) {
        testService.deleteByIdRedis(id);
    }
}
