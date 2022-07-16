package com.cn.version2.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cn.version2.R;

/**
 * description: none
 *
 * @author yan.w.s@qq.com
 * time: 2022/7/6
 * version: 1.0
 * update: none
 */
public class LoginActivity extends AppCompatActivity implements LoginContact.View {
    private LoginContact.Presenter mPresenter;

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    private ProgressBar mPbLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version2_activity_login);
        mPresenter = new LoginPresenter(this);
        initView();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        mEdtUsername = findViewById(R.id.version2_login_edt_username);
        mEdtPassword = findViewById(R.id.version2_login_edt_password);
        mBtnLogin = findViewById(R.id.version2_login_btn_login);
        mPbLoading = findViewById(R.id.version2_login_pb_loading);
    }

    private void initListener() {
        mBtnLogin.setOnClickListener(v -> mPresenter.login());
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
