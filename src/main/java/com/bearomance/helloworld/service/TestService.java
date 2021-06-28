package com.bearomance.helloworld.service;

import com.bearomance.helloworld.model.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xmj
 * @since 2021-06-25
 */
public interface TestService extends IService<Test> {

    Test findByIdRedis(Integer id);
    Test updateRedis(Test test);
    void deleteByIdRedis(Integer id);
}
