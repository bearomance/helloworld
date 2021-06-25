package com.bearomance.helloworld.model.mapper;

import com.bearomance.helloworld.model.entity.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bearomance.helloworld.model.vo.TestVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xmj
 * @since 2021-06-25
 */
public interface TestMapper extends BaseMapper<Test> {

    @Select("SELECT test.id, test.name as name, description, item.name as itemName FROM test left join item on test.item_id=item.id")
    List<TestVO> testVO();
}
