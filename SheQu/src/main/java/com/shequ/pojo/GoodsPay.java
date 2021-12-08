package com.shequ.pojo;

public class GoodsPay {
    private String goods_id;
    private String uid;

    public GoodsPay() {
    }

    public GoodsPay(String goods_id, String uid) {
        this.goods_id = goods_id;
        this.uid = uid;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "GoodsPay{" +
                "goods_id='" + goods_id + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
