package com.wislie.hook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.wislie.hook.helper.HookStartActivityHelper;
import com.wislie.hook.helper.LifeCycleListenerHelper;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Switch aSwitch = findViewById(R.id.switch_login);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //已登录
                    aSwitch.setText("已登录");
                    HookStartActivityHelper.isLogin = true;
                } else {
                    //未登录
                    aSwitch.setText("未登录");
                    HookStartActivityHelper.isLogin = false;
                }
            }
        });

        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
        //hook activity的生命周期
        LifeCycleListenerHelper.hook(this);

        //hook startActivity
        HookStartActivityHelper.hookStartActivity(this);


    }
}
