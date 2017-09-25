package com.example.leejh.myscanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by SonYoungHoon on 2017-09-20.
 */

public class IntroActivity extends Activity{



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(IntroActivity.this, DeviceList.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

}
