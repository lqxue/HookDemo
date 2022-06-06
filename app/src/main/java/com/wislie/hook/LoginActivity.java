package com.wislie.hook;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 2020/3/27 8:19 PM
 * desc   : 未登录
 * version: 1.0
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setText("未登录");
        setContentView(tv);
    }
}
