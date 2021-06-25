package com.bearomance.helloworld.service.impl;

import com.bearomance.helloworld.model.entity.Test;
import com.bearomance.helloworld.model.mapper.TestMapper;
import com.bearomance.helloworld.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {


}
