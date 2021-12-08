package com.shequ.pojo;

public class User {
    private String uid;
    private String name;
    private String gender;
    private String buildingNumber;
    private String unitNumber;
    private String roomNumber;
    private String phone_number;
    private String roomId;
    private String pwd;
    public User() {
    }

    public User(String uid, String name, String gender, String buildingNumber, String unitNumber, String roomNumber, String phone_number, String roomId, String pwd) {
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.buildingNumber = buildingNumber;
        this.unitNumber = unitNumber;
        this.roomNumber = roomNumber;
        this.phone_number = phone_number;
        this.roomId = roomId;
        this.pwd = pwd;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", unitNumber='" + unitNumber + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", roomId='" + roomId + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}