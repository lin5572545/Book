package com.shequ.mapper;

import com.shequ.pojo.Goods;
import com.shequ.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {
    List<Goods>findAllGoods();
    Goods findGoodsById(String id);
    List<Goods>findAllGoodsByPages(int satrt,int pagesize);
    int deleteGoodsById(String goods_id);
    int updateGoodsById(Map map);
    int insertGoods(Map map);
}
