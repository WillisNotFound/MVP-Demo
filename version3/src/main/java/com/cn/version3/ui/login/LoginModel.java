package com.cn.version3.ui.login;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public class LoginModel {
    public void login(String username, String password, LoginContact.LoginCallback loginCallback) {
        new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (username == null || username.isEmpty()) {
                loginCallback.onFailed(LoginContact.LoginCallback.EMPTY_USERNAME);
            } else if (password == null || password.isEmpty()) {
                loginCallback.onFailed(LoginContact.LoginCallback.EMPTY_PASSWORD);
            } else if ("123456".equals(username) && "123456".equals(password)) {
                loginCallback.onSuccess();
            } else {
                loginCallback.onFailed(LoginContact.LoginCallback.ERROR_INPUT);
            }
        }).start();
    }
}
