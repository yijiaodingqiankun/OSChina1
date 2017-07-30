package com.jiyun.dell.oschina.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText login;
    private EditText pass;
    private TextView tv_wjmm;
    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        login = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.pass);
        tv_wjmm = (TextView) findViewById(R.id.tv_wjmm);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        submit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                break;
            case R.id.btn_register:

                break;
        }
    }

    private void submit() {
        // validate
        String loginString = login.getText().toString().trim();
        String passString = pass.getText().toString().trim();
        Log.e("submit: ",loginString+ passString);
        if (TextUtils.isEmpty(loginString) && TextUtils.isEmpty(passString)) {
            btn_login.setBackground(getResources().getDrawable(R.drawable.btn_login));
            btn_login.setTextColor(getResources().getColor(R.color.hui));

        }else if(!TextUtils.isEmpty(loginString) && !TextUtils.isEmpty(passString)){
            btn_login.setBackground(getResources().getDrawable(R.drawable.btn_bg));
        }


    }
}
