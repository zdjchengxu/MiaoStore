package com.zdj.miaostore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zdj.miaostore.R;
import com.zdj.miaostore.base.BaseActivity;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.presenter.RegisterPresenter;
import com.zdj.miaostore.interfaces.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<RegisterView, RegisterPresenter> implements RegisterView {

    @BindView(R.id.iv_back_register)
    ImageView ivBackRegister;
    @BindView(R.id.ed_userphone_register)
    EditText edUserPhoneRegister;
    @BindView(R.id.ed_pwd_register)
    EditText edPwdRegister;
    @BindView(R.id.btn_confirm_register)
    Button btnConfirmRegister;
    @BindView(R.id.tv_error_register)
    TextView tvErrorRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected RegisterView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    private void initView() {
        btnConfirmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPhone = edUserPhoneRegister.getText().toString();
                String userPwd = edPwdRegister.getText().toString();
                getPresenter().sendRegister("15607535217", "zdj123");
            }
        });
        ivBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onRegisterSuccess(NetBack mNetBack) {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                /*Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);*/
                finish();
            }
        });
    }

    @Override
    public void onRegisterError(final NetBack mNetBack) {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                tvErrorRegister.setText(mNetBack.getMsg());
            }
        });
    }
}
