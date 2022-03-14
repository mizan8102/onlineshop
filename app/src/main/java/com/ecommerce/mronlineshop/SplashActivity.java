package com.ecommerce.mronlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.onesignal.OneSignal;

public class SplashActivity extends AppCompatActivity {
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        changeStatusBarColor();
        setContentView(R.layout.activity_splash);
        progressBar=(ProgressBar)findViewById(R.id.ProgressBar);
        //Hide for STATUS BAR HIDE
        // END
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                ValuerText();
            }
        });
        thread.start();

    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }
    void ValuerText(){
        for ( int i = 20; i != 100;) {
            i=i+20;
            try {
                Thread.sleep(1000);
                progressBar.setProgress(i);


                if (i==100){
                    SharedPreferences sp=getApplicationContext().getSharedPreferences
                            ("com.ecommerce.mronlineshop", Context.MODE_PRIVATE);
                    String email=sp.getString("user_email","");
                    if (TextUtils.isEmpty(email)){
                        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        Animatoo.animateSwipeRight(this);
                    }
                    else {
                        Intent intent=new Intent(SplashActivity.this,MainHome.class);
                        startActivity(intent);
                        finish();
                        Animatoo.animateSwipeRight(this);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}