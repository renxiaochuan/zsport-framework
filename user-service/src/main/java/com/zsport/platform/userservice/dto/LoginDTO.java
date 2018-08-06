package com.zsport.platform.userservice.dto;

import com.zsport.platform.userservice.entity.User;

/**
 * Created by fangzhipeng on 2017/7/10.
 */
public class LoginDTO {
    private User user;
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
