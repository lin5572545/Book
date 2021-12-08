package com.shequ.service;

import com.shequ.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> findAllGoods();
    Goods findGoodsById(String id);
    List<Goods>findAllGoodsByPages(int satrt,int pagesize);
    int deleteGoodsById(String goods_id);
    int updateGoodsById(Map map);
    int insertGoods(Map map);
}
