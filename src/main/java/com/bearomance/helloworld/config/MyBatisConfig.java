package com.bearomance.helloworld.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bearomance.helloworld.model.mapper")
public class MyBatisConfig {
}
