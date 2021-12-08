package com.shequ.service;

import com.shequ.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsPayService {
    public int insertBuyGoods(Map map);
    List<Goods>findMyGoods(String uid);
    List<Goods>findAllGoodsPay();
    List<Goods>findAllGoodsPayByPage(int satrt,int pagesize);
}
