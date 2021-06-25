package com.bearomance.helloworld.controller;

import cn.hutool.core.lang.Console;
import com.bearomance.helloworld.model.entity.Test;
import com.bearomance.helloworld.model.mapper.TestMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/t1")
    public String t1() {
        return "t1 success";
    }

    @Resource
    private TestMapper testMapper;

    @GetMapping("/t2")
    public String t2() {
        List<Test> tests = testMapper.selectList(null);
        Console.log(tests);
        return "t2 success";
    }
}
