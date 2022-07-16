package com.cn.learnmvp.ui.login;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public interface ILoginView {
    String getUsername();

    String getPassword();

    void clearUsername();

    void clearPassword();

    void hideLoading();

    void showLoading();

    void loginSuccess();

    void showErrorMsg(String failedMsg);
}
