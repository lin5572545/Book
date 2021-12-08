package com.shequ.service.impl;

import com.shequ.mapper.GoodsMapper;
import com.shequ.pojo.Goods;
import com.shequ.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public Goods findGoodsById(String id) {
        return goodsMapper.findGoodsById(id);
    }

    @Override
    public List<Goods> findAllGoodsByPages(int satrt, int pagesize) {
        return goodsMapper.findAllGoodsByPages(satrt, pagesize);
    }

    @Override
    public int deleteGoodsById(String goods_id) {
        return goodsMapper.deleteGoodsById(goods_id);
    }

    @Override
    public int updateGoodsById(Map map) {
        return goodsMapper.updateGoodsById(map);
    }

    @Override
    public int insertGoods(Map map) {
        return goodsMapper.insertGoods(map);
    }
}
