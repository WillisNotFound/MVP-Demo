package com.cn.version3.ui.login;

import android.os.Handler;
import android.os.Looper;

import com.cn.version3.base.BasePresenter;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presenter {
    private final LoginModel mLoginModel;
    private final Handler mHandler;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void login() {
        mView.showLoading();
        mLoginModel.login(mView.getUsername(), mView.getPassword(), new LoginContact.LoginCallback() {
            @Override
            public void onSuccess() {
                mHandler.post(() -> {
                    mView.loginSuccess();
                    mView.hideLoading();
                    mView.clearUsername();
                    mView.clearPassword();
                });
            }

            @Override
            public void onFailed(int option) {
                mHandler.post(() -> {
                    switch (option) {
                        case EMPTY_USERNAME:
                            mView.showErrorMsg("empty username");
                            break;
                        case EMPTY_PASSWORD:
                            mView.showErrorMsg("empty password");
                            break;
                        case ERROR_INPUT:
                            mView.showErrorMsg("error input");
                            break;
                        default:
                            break;
                    }
                    mView.hideLoading();
                });
            }
        });
    }
}
