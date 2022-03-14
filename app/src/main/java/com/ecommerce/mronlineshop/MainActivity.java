package com.ecommerce.mronlineshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.ecommerce.mronlineshop.models.PlatModel;
import com.ecommerce.mronlineshop.models.Plate_Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;


public class MainActivity<runnable, speedScroll> extends AppCompatActivity {


   private RecyclerView recyclerView;
   private List<PlatModel> list;
   private Plate_Adapter plate_adapter;
    private ProgressDialog pDialog;
   private String link="https://mrshop2001.000webhostapp.com/mshop/ajax/API/catagories.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeStatusBarColor();
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this) {
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView,RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(MainActivity.this) {
                    private static final float SPEED = 4000f;// Change this value (default=25f)
                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }

        };
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        datashow();




        //autoScroll();

    }

    private void datashow() {
        list=new ArrayList<>();
        final String pic;

        final RequestQueue requestQueue= Volley.newRequestQueue(getApplication());

        StringRequest stringRequest=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("catagories");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        PlatModel p=new PlatModel();
                       JSONObject job=jsonArray.getJSONObject(i);
                     p.setPlate_img(job.getString("cat_image"));
                     list.add(p);
                    }
                    plate_adapter=new Plate_Adapter(getApplicationContext(),list);
                    recyclerView.setAdapter(plate_adapter);
                    plate_adapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplication(),"Network Error",Toast.LENGTH_SHORT).show();

                requestQueue.stop();
            }

        });
        requestQueue.add(stringRequest);




    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }

    public void autoScroll(){
        final int speedScroll = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
              if(count == plate_adapter.getItemCount()) {
                  count =0;
              }
                if(count < plate_adapter.getItemCount()) {
                    recyclerView.smoothScrollToPosition(++count);
                }
                handler.postDelayed(this,speedScroll);
            }

    };
        handler.postDelayed(runnable,speedScroll);
}




    public void login(View view) {
        startActivity(new Intent(MainActivity.this,Login_Activity.class));

        Animatoo.animateSlideDown(this);

    }

    public void registration(View view) {
        startActivity(new Intent(MainActivity.this,RegistrationActivity.class));

        Animatoo.animateSlideDown(this);
    }

    public void skipbtn(View view) {
        startActivity(new Intent(MainActivity.this,MainHome.class));

        Animatoo.animateSwipeLeft(this);
    }
}