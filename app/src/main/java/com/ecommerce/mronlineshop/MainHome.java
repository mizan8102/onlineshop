package com.ecommerce.mronlineshop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecommerce.mronlineshop.fragment.AccountFragment;
import com.ecommerce.mronlineshop.fragment.GoOutFragment;
import com.ecommerce.mronlineshop.fragment.GoldFragment;
import com.ecommerce.mronlineshop.fragment.NewOrderFragment;
import com.ecommerce.mronlineshop.fragment.OrderFragment;
import com.ecommerce.mronlineshop.fragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.ecommerce.mronlineshop.R.layout.fragment_new_order;

public class MainHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;
    private  DrawerLayout drawer;
    private TextView nav_herader_name,nav_header_email;
    private EditText searchbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // changeStatusBarColor();
        setContentView(R.layout.activity_main_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setTitle("Menu");
        searchbar=findViewById(R.id.search_bar_header);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view=navigationView.getHeaderView(0);
        nav_herader_name=(TextView)view.findViewById(R.id.tv_dashboardHeader_profileName);
        nav_header_email=(TextView)view.findViewById(R.id.tv_dashboardHeader_profileemail);



        frameLayout=(FrameLayout)view.findViewById(R.id.frameLayout);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottonnavigationViewhome);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigaton);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new NewOrderFragment()).commit();
        SharedPreferences sp=getApplicationContext().getSharedPreferences
                ("com.ecommerce.mronlineshop", Context.MODE_PRIVATE);
        String name=sp.getString("user_name","");
        String email=sp.getString("user_email","");
        nav_herader_name.setText(name);
        nav_header_email.setText(email);



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.orderid, R.id.goldid, R.id.orderid,R.id.favouriteid,R.id.adressid,R.id.helpid,R.id.rateid,R.id.aboutid,R.id.feedbackid
        ,R.id.nav_login,R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                   switch (item.getItemId()){
                case android.R.id.home:
                    drawer.openDrawer(GravityCompat.START);
                    break;


        }
        return super.onOptionsItemSelected(item);
    }
  /*  private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }*/
    private BottomNavigationView.OnNavigationItemSelectedListener navigaton=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectFragment=null;
                    switch (item.getItemId()){
                        case R.id.order:
                            selectFragment= new NewOrderFragment();
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
                        case R.id.account:
                            selectFragment=new AccountFragment();
                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectFragment).commit();

                    return true;
                }
            };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {

        return  super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.bookmarkid:
                Toast.makeText(getApplication(),"Bookmarks",Toast.LENGTH_SHORT).show();

                break;
            case R.id.goldid:
                Toast.makeText(getApplication(),"Gold",Toast.LENGTH_SHORT).show();
                break;
            case R.id.orderid:
                Toast.makeText(getApplication(),"YOur order",Toast.LENGTH_SHORT).show();
                break;
            case R.id.favouriteid:
                Toast.makeText(getApplication(),"favourite",Toast.LENGTH_SHORT).show();
                break;
            case R.id.adressid:
                Toast.makeText(getApplication(),"address",Toast.LENGTH_SHORT).show();
                break;
            case R.id.helpid:
                Toast.makeText(getApplication(),"Help",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedbackid:
                Toast.makeText(getApplication(),"Feedback",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rateid:
                Toast.makeText(getApplication(),"Rate us",Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutid:
                Toast.makeText(getApplication(),"About",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_login:
                startActivity(new Intent(MainHome.this,Login_Activity.class));
                finish();
                Toast.makeText(getApplication(),"login",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                SharedPreferences sp=getApplicationContext().getSharedPreferences
                        ("com.ecommerce.mronlineshop", Context.MODE_PRIVATE);

                sp.edit().remove("user_name").apply();
                sp.edit().remove("user_email").apply();
                sp.edit().remove("user_phone").apply();
                sp.edit().remove("user_password").apply();
                Toast.makeText(getApplicationContext(),"Log Out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainHome.this,Login_Activity.class));
                finish();

                break;


        }
        return true;
    }
}