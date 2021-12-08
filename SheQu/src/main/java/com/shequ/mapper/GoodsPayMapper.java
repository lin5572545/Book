package com.shequ.mapper;

import com.shequ.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsPayMapper {
    public int insertBuyGoods(Map map);
    List<Goods>findMyGoods(String uid);
    List<Goods>findAllGoodsPay();
    List<Goods>findAllGoodsPayByPage(int satrt,int pagesize);
}
