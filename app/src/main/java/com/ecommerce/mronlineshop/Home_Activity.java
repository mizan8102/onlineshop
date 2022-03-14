package com.ecommerce.mronlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ecommerce.mronlineshop.fragment.GoOutFragment;
import com.ecommerce.mronlineshop.fragment.GoldFragment;
import com.ecommerce.mronlineshop.fragment.OrderFragment;
import com.ecommerce.mronlineshop.fragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      changeStatusBarColor();
        setContentView(R.layout.activity_home_);


        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottonnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigaton);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new OrderFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigaton=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectFragment=null;
                    switch (item.getItemId()){
                        case R.id.order:
                          selectFragment= new OrderFragment();
                           break;
                        case R.id.goout:
                            selectFragment=new GoOutFragment();
                            break;
                        case R.id.gold:
                           selectFragment=new GoldFragment();
                            break;
                        case R.id.video:
                            selectFragment=new VideoFragment();
                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectFragment).commit();

                    return true;
                }
            };









    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            // window.setStatusBarColor(getResources().getColor(R.color.white));
        }

    }

}