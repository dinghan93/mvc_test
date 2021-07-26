package com.kkb.xzk.bean;

import java.util.Objects;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-24 15:04
 * @Modified By:
 */
public class User {
    private Integer userid;
    private String username;
    private String userpass;

    public User() {
    }

    public User(Integer userid, String username, String userpass) {
        this.userid = userid;
        this.username = username;
        this.userpass = userpass;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserid(), user.getUserid()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getUserpass(), user.getUserpass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getUsername(), getUserpass());
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                '}';
    }
}
