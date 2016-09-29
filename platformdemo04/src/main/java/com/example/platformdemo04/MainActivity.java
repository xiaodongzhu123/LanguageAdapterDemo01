package com.example.platformdemo04;

import android.content.Context;
import android.graphics.ImageFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取当前手机运行的版本号
        int versionNumber= Build.VERSION.SDK_INT;
        System.out.println("versionNumber="+versionNumber);
        if(versionNumber>=Build.VERSION_CODES.HONEYCOMB){
            Toast.makeText(this, "当前手机运行的版本号高于3.0,可以使用3.0新特性!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "当前手机运行的版本号低于3.0,不能使用3.0新特性!", Toast.LENGTH_SHORT).show();
        }


        int statusBarHeight=getStatusBarHeight(this);
        System.out.println("statusBarHeight="+statusBarHeight);
    }


    /**
     * 获取系统状态栏的高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        java.lang.reflect.Field field = null;
        int x = 0;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
            return statusBarHeight;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}
