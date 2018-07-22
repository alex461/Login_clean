package com.alex.app_clean.model;


public class Picture {


    private String like_number;
    private String picture;
    private String time;
    private String userName;

    public Picture() {
    }

    public Picture(String like_number, String picture, String time, String userName) {
        this.like_number = like_number;
        this.picture = picture;
        this.time = time;
        this.userName = userName;
    }

    public String getLike_number() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
