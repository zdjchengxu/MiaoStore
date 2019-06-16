package com.zdj.miaostore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.zdj.miaostore.R;
import com.zdj.miaostore.base.BaseActivity;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.presenter.LoginPresenter;
import com.zdj.miaostore.interfaces.LoginView;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.SharedPreferencesManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.at_phone_login)
    AutoCompleteTextView atPhoneLogin;
    @BindView(R.id.ed_pwd_login)
    EditText edPwdLogin;
    @BindView(R.id.btn_confirm_login)
    Button btnConfirmLogin;
    @BindView(R.id.iv_register_login)
    ImageView ivRegisterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isLogined()) {
            setContentView(R.layout.activity_login);
            ButterKnife.bind(this);
            initView();
        }
    }

    private void initView() {
        btnConfirmLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String userPhone = atPhoneLogin.getText().toString();
//                String userPwd = edPwdLogin.getText().toString();
                getPresenter().sendLogin("15617535217", "zdj123");
            }
        });
        ivRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * 判断是否保存了登录信息
     */
    public boolean isLogined() {
        String userphone = SharedPreferencesManager.getInstance("setting").getValue("userphone", String.class);
        String userpwd = SharedPreferencesManager.getInstance("setting").getValue("userpwd", String.class);
        LogUtil.e(TAG, "来了userp: " + userphone + "   pwd: " + userpwd);
        if (userphone.equals("") && userpwd.equals("")) {
            return false;
        } else {
            getPresenter().sendLogin(userphone, userpwd);
            return true;
        }
    }

    /**
     * 判断是否是第一次登录
     */
    public boolean isLoginFirst() {
        Boolean value = SharedPreferencesManager.getInstance("setting").getValue("isFrist", Boolean.class);
        //第一次登录
        SharedPreferencesManager.getInstance("setting").putValue("isFrist", false);
        return value;
    }

    /**
     * 保存第一次登录的用户名和密码
     */
    public void setFirstLoginMsg(String userphone, String userpwd) {
        SharedPreferencesManager.getInstance("setting").putValue("userphone", userphone);
        SharedPreferencesManager.getInstance("setting").putValue("userpwd", userpwd);
    }

    public void intentHomepage() {
        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
        startActivity(intent);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected LoginView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    public void onLoginSuccess(final User user) {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                LogUtil.e(TAG, user.toString());
                Toast.makeText(LoginActivity.this, "UserName" + user.getData().getUsername(), Toast.LENGTH_LONG).show();
                MyStoreApplication application = (MyStoreApplication) getApplication();
                application.createUser(user);
                if (!isLoginFirst()) {
                    setFirstLoginMsg(user.getData().getUserPhone(), user.getData().getUserPassword());
                }
                intentHomepage();
            }
        });
    }

    @Override
    public void onLoginError() {

    }


}
