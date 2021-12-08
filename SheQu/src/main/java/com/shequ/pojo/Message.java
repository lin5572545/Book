package com.shequ.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Message {
    private int id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String author;
    private String content;
    private String img;
    private String title;
    private String avatarUrl;

    public Message() {
    }

    public Message(Date time, String author, String content, String img, String title, String avatarUrl) {
        this.time = time;
        this.author = author;
        this.content = content;
        this.img = img;
        this.title = title;
        this.avatarUrl = avatarUrl;
    }

    public Message(int id, Date time, String author, String content, String img, String title, String avatarUrl) {
        this.id = id;
        this.time = time;
        this.author = author;
        this.content = content;
        this.img = img;
        this.title = title;
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", time=" + time +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
