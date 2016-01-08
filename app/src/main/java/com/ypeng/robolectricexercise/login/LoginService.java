package com.ypeng.robolectricexercise.login;

public class LoginService {
    public boolean login(String username, String password) {
        return "test".equals(username) && "123".equals(password);
    }
}
