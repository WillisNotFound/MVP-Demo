package com.cn.learnmvp.ui.login;

import android.os.Handler;
import android.os.Looper;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public class LoginPresenter implements ILoginPresenter {
    private final ILoginView mLoginView;
    private final LoginModel mLoginModel;
    private final Handler mHandler;

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModel();
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void login() {
        mLoginView.showLoading();
        LoginCallback callback = new LoginCallback() {
            @Override
            public void onSuccess() {
                mHandler.post(() -> {
                    mLoginView.hideLoading();
                    mLoginView.loginSuccess();
                    mLoginView.clearUsername();
                    mLoginView.clearPassword();
                });
            }

            @Override
            public void onFailed(int option) {

                mHandler.post(() -> {
                    switch (option) {
                        case EMPTY_USERNAME:
                            mLoginView.showErrorMsg("empty username");
                            break;
                        case EMPTY_PASSWORD:
                            mLoginView.showErrorMsg("empty password");
                            break;
                        case ERROR_INPUT:
                            mLoginView.showErrorMsg("error input");
                            break;
                        default:
                            break;
                    }
                    mLoginView.hideLoading();
                });
            }
        };
        mLoginModel.login(mLoginView.getUsername(), mLoginView.getPassword(), callback);
//            @Override
//            public void onSuccess() {
//                mHandler.post(() -> {
//                    mLoginView.loginSuccess();
//                    mLoginView.hideLoading();
//                    mLoginView.clearUsername();
//                    mLoginView.clearPassword();
//                });
//            }
//
//            @Override
//            public void onFailed(int option) {
//                mHandler.post(() -> {
//                    switch (option) {
//                        case EMPTY_USERNAME:
//                            mLoginView.showErrorMsg("empty username");
//                            break;
//                        case EMPTY_PASSWORD:
//                            mLoginView.showErrorMsg("empty password");
//                            break;
//                        case ERROR_INPUT:
//                            mLoginView.showErrorMsg("error input");
//                            break;
//                        default:
//                            break;
//                    }
//                    mLoginView.hideLoading();
//                });
//            }
//        });
    }
}
