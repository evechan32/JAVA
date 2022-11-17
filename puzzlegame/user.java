package com.qyw.ui;

public class user {
    public String username;
    public String usercode;

    public user() {
    }

    public user(String username, String usercode) {
        this.username = username;
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
}
