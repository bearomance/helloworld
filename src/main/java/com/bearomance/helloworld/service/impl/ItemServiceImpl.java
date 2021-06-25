package com.bearomance.helloworld.service.impl;

import com.bearomance.helloworld.model.entity.Item;
import com.bearomance.helloworld.model.mapper.ItemMapper;
import com.bearomance.helloworld.service.ItemService;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

}
