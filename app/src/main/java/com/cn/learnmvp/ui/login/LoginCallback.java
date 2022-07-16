package com.cn.learnmvp.ui.login;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public interface LoginCallback {
    int EMPTY_USERNAME = 0;
    int EMPTY_PASSWORD = 1;
    int ERROR_INPUT = 2;

    void onSuccess();

    void onFailed(int option);
}
