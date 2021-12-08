package com.shequ.pojo;

public class Repair {
    private int id;
    private String uid;
    private String my_content;
    private String my_area;
    private String pic0;
    private String pic1;
    private String pic2;
    private String name;

    public Repair() {
    }

    public Repair(String my_content, String my_area, String pic0, String pic1, String pic2) {
        this.my_content = my_content;
        this.my_area = my_area;
        this.pic0 = pic0;
        this.pic1 = pic1;
        this.pic2 = pic2;
    }

    public Repair(int id, String my_content, String my_area, String pic0, String pic1, String pic2) {
        this.id = id;
        this.my_content = my_content;
        this.my_area = my_area;
        this.pic0 = pic0;
        this.pic1 = pic1;
        this.pic2 = pic2;
    }

    public Repair(int id, String uid, String my_content, String my_area, String pic0, String pic1, String pic2) {
        this.id = id;
        this.uid = uid;
        this.my_content = my_content;
        this.my_area = my_area;
        this.pic0 = pic0;
        this.pic1 = pic1;
        this.pic2 = pic2;
    }

    public Repair(int id, String uid, String my_content, String my_area, String pic0, String pic1, String pic2, String name) {
        this.id = id;
        this.uid = uid;
        this.my_content = my_content;
        this.my_area = my_area;
        this.pic0 = pic0;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMy_content() {
        return my_content;
    }

    public void setMy_content(String my_content) {
        this.my_content = my_content;
    }

    public String getMy_area() {
        return my_area;
    }

    public void setMy_area(String my_area) {
        this.my_area = my_area;
    }

    public String getPic0() {
        return pic0;
    }

    public void setPic0(String pic0) {
        this.pic0 = pic0;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", my_content='" + my_content + '\'' +
                ", my_area='" + my_area + '\'' +
                ", pic0='" + pic0 + '\'' +
                ", pic1='" + pic1 + '\'' +
                ", pic2='" + pic2 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
