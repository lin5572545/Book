package com.shequ.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Goods {
    private String goods_id;
    private String goods_title;
    private String goods_desc;
    private String goods_img;
    private String goods_price;
    private String publisher_id;
    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date publish_time;

    public Goods() {
    }

    public Goods(String goods_id, String goods_title, String goods_desc, String goods_img, String goods_price, String publisher_id, String name, Date publish_time) {
        this.goods_id = goods_id;
        this.goods_title = goods_title;
        this.goods_desc = goods_desc;
        this.goods_img = goods_img;
        this.goods_price = goods_price;
        this.publisher_id = publisher_id;
        this.name = name;
        this.publish_time = publish_time;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {this.goods_price = goods_price;}

    public String getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(String publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id='" + goods_id + '\'' +
                ", goods_title='" + goods_title + '\'' +
                ", goods_desc='" + goods_desc + '\'' +
                ", goods_img='" + goods_img + '\'' +
                ", goods_price='" + goods_price + '\'' +
                ", publisher_id='" + publisher_id + '\'' +
                ", name='" + name + '\'' +
                ", publish_time=" + publish_time +
                '}';
    }
}
