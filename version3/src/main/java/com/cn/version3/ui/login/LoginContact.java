package com.cn.version3.ui.login;

import com.cn.version3.base.IBasePresenter;
import com.cn.version3.base.IBaseView;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public interface LoginContact {
    interface View extends IBaseView {
        String getUsername();

        String getPassword();

        void clearUsername();

        void clearPassword();

        void hideLoading();

        void showLoading();

        void loginSuccess();

        void showErrorMsg(String failedMsg);
    }

    interface Presenter extends IBasePresenter<View> {
        void login();
    }

    interface LoginCallback {
        int EMPTY_USERNAME = 0;
        int EMPTY_PASSWORD = 1;
        int ERROR_INPUT = 2;

        void onSuccess();

        void onFailed(int option);
    }
}
