package com.example.lenovo.languageadapterdemo01;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_userName;
    private EditText editText_pwd;

    /**
     * 声明资源对象
     */
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resources=this.getResources();

        this.initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        this.editText_userName= (EditText) this.findViewById(R.id.editText_userName);
        this.editText_pwd= (EditText) this.findViewById(R.id.editText_pwd);
    }


    /**
     * 登录
     * @param view
     */
    public void login(View view){
        String userName=this.editText_userName.getText().toString();
        if(TextUtils.isEmpty(userName)){
            this.editText_userName.setError(this.resources.getString(R.string.userNameNoEmpty));
            this.editText_userName.requestFocus();
            return;
        }


        this.editText_pwd.requestFocus();
        String pwd=this.editText_pwd.getText().toString();
        if(TextUtils.isEmpty(pwd)){
            this.editText_pwd.setError(this.resources.getString(R.string.pwdNoEmpty));
            this.editText_pwd.requestFocus();
            return;
        }


        if("admin".equals(userName) && "123".equals(pwd)){
            Toast.makeText(this, userName+" "+this.resources.getString(R.string.loginSuccess), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, this.resources.getString(R.string.userNameOrPwdError), Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * 重置
     * @param view
     */
    public void reset(View view){
        this.editText_userName.setText(null);
        this.editText_pwd.setText(null);
        this.editText_userName.requestFocus();
    }
}
