package com.cn.version3.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.cn.version3.R;
import com.cn.version3.base.BaseActivity;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public class LoginActivity extends BaseActivity<LoginContact.Presenter> implements LoginContact.View {
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private ProgressBar mPbLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version3_activity_login);
        initView();
        initListener();
    }

    private void initView() {
        mEdtUsername = findViewById(R.id.version3_login_edt_username);
        mEdtPassword = findViewById(R.id.version3_login_edt_password);
        mBtnLogin = findViewById(R.id.version3_login_btn_login);
        mPbLoading = findViewById(R.id.version3_login_pb_loading);
    }

    private void initListener() {
        mBtnLogin.setOnClickListener(v -> mPresenter.login());
    }

    @Override
    protected LoginContact.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getUsername() {
        return mEdtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdtPassword.getText().toString();
    }

    @Override
    public void clearUsername() {
        mEdtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEdtPassword.setText("");
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg(String failedMsg) {
        Toast.makeText(this, failedMsg, Toast.LENGTH_SHORT).show();
    }
}
