package com.kaituo.comparison.back.core.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaituo.comparison.back.core.entity.shop.Shop;
import com.kaituo.comparison.back.core.mapper.shop.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/4/8 13:40
 * @Modified by:
 */
@Component
public class InitCache {

    public static Map<String, String> map = new HashMap<>();

    @Autowired
    ShopMapper shopMapper;

    @PostConstruct
    public void init() {
        System.out.println("系统启动中。。。加载shop");
        List<Shop> shops = shopMapper.selectList(new QueryWrapper<>());
        shops.forEach(v -> map.put(v.getId(), v.getShopname()));
    }

}
