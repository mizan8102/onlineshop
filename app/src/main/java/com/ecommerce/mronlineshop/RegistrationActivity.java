package com.ecommerce.mronlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.util.Util;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class RegistrationActivity extends AppCompatActivity {

    private EditText tname,temail,tnumber,tpassword;
    private ImageView imageView;
    private String name,email,number,password;
    private GifImageView pv;
    private String link="https://mrshop2001.000webhostapp.com/mshop/User/email_registration.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeStatusBarColor();
        setContentView(R.layout.activity_registration);
        tname=findViewById(R.id.txtname);
        temail=findViewById(R.id.txtemail);
        tnumber=findViewById(R.id.txtphone);
        tpassword=findViewById(R.id.txtpassword);
        imageView=findViewById(R.id.txtregistration);
        pv=findViewById(R.id.progress_circularid);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                name=tname.getText().toString();
                email=temail.getText().toString();
                number=tnumber.getText().toString();
                password=tpassword.getText().toString();
                if (TextUtils.isEmpty(name)){
                    tname.setError("name required");
                    Snackbar.make(view,"Name is required",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    tname.requestFocus();
                }
                else  if (TextUtils.isEmpty(email)){
                    temail.setError("e-mail required");
                    Snackbar.make(view,"e-mail is required",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    temail.requestFocus();
                }
                else  if (TextUtils.isEmpty(number)){
                    tnumber.setError("number required");
                    Snackbar.make(view,"number is required",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    tnumber.requestFocus();
                }
                else  if (TextUtils.isEmpty(password)){
                    tpassword.setError("password required");
                    Snackbar.make(view,"password is required",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    tpassword.requestFocus();
                }
                else  if (password.length()<6){
                    tpassword.setError("password more than 6 digit");
                    Snackbar.make(view,"password more than 6 digit",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    tpassword.requestFocus();
                }
                else {
                    pv.setVisibility(View.VISIBLE);
                    final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();

                            tname.setText("");
                            temail.setText("");
                            tnumber.setText("");
                            tpassword.setText("");
                            tname.requestFocus();
                            startActivity(new Intent(RegistrationActivity.this,Login_Activity.class));
                            finish();
                           // Animatoo.animateSlideLeft(getApplicationContext());
                            pv.setVisibility(View.INVISIBLE);
                            requestQueue.stop();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_SHORT).show();
                            Snackbar.make(view,"Network Error.Try again",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                            requestQueue.stop();

                            pv.setVisibility(View.INVISIBLE);
                        }
                    }){
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("user_name",name);
                            params.put("user_email", email);
                            params.put("user_number",number);
                            params.put("user_password", password);
                            return params;
                        }
                    };


                    requestQueue.add(stringRequest);


                //finish
                }
            }
        });


    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//
        }

    }

    public void login(View view) {

        startActivity(new Intent(RegistrationActivity.this,Login_Activity.class));
        Animatoo.animateSlideUp(this);
    }
}