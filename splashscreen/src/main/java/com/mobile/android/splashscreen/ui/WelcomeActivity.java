package com.mobile.android.splashscreen.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobile.android.splashscreen.R;


public class WelcomeActivity extends Activity {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        mContentView = findViewById(R.id.fullscreen_content);

        Toast.makeText(this, "mContentView:" + mContentView, Toast.LENGTH_SHORT).show();
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                toggle();
                Toast.makeText(WelcomeActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mContentView.postDelayed(new Runnable() {
            @Override
            public void run() {
//                //跳转到APP首页的MainActivity(app目录)
//                Intent intent = new Intent();
//                //
//                intent.setClassName(getBaseContext(),"com.taobao.demo.MainActivity");
//                startActivity(intent);
//                finish();
//                overridePendingTransition(-1,android.R.anim.slide_out_right);
            }
        },3000);
    }
}
