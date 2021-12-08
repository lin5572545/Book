package com.shequ.pojo;

public class Admin {
    private int id;
    private String name;
    private String account;
    private String pwd;

    public Admin() {
    }

    public Admin(String name, String account, String pwd) {
        this.name = name;
        this.account = account;
        this.pwd = pwd;
    }

    public Admin(int id, String name, String account, String pwd) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.pwd = pwd;
    }

    public Admin(String name, String account) {
        this.name = name;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
