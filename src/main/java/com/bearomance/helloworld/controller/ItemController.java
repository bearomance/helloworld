package com.bearomance.helloworld.controller;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.bearomance.helloworld.model.entity.Item;
import com.bearomance.helloworld.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/item")
@RestController
public class ItemController {

    @Resource
    private ItemService itemService;

    @GetMapping("/getItemTree")
    public List<Tree<Integer>> getItemTree() {

        List<Item> items = itemService.list();

        TreeNodeConfig config = new TreeNodeConfig();
        config.setWeightKey("weight");

        return TreeUtil.build(items, 0, config, (object, tree) -> {
            tree.putExtra("id", object.getId());
            tree.putExtra("parentId", object.getParentId());
            tree.putExtra("name", object.getName());
            tree.putExtra("detail", object.getDetail());
            tree.putExtra("type", object.getType());
            tree.putExtra("weight", object.getWeight());
        });
    }

    @GetMapping("/getItem")
    public Item getItem(Integer id) {
        return itemService.getById(id);
    }

}
