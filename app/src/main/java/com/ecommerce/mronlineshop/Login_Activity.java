package com.ecommerce.mronlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class Login_Activity extends AppCompatActivity {

    private EditText txtemail,txtpassword;
    private String link="https://mrshop2001.000webhostapp.com/mshop/User/login.php";
    private String email,password,name,phone,semail,spassword;
    private GifImageView progressBar;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       changeStatusBarColor();

        setContentView(R.layout.activity_login_);
        txtemail=findViewById(R.id.username_input);
        txtpassword=findViewById(R.id.pass);
        progressBar=findViewById(R.id.progresslogin);
        button=findViewById(R.id.txtlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                progressBar.setVisibility(View.VISIBLE);
                email = txtemail.getText().toString();
                password = txtpassword.getText().toString();
                final String[] res = new String[1];
                final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            res[0] =response;
                        String am=res[0];
                        int match=am.length();
                            if (match==7){
                                Toast.makeText(getApplicationContext(),"Your password or email is wrong",Toast.LENGTH_SHORT).show();
                                Snackbar.make(view,"Your password or email is wrong.Try Again",Snackbar.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                            else {
                                JSONArray jsonArray=new JSONArray(response);
                                JSONObject job = jsonArray.getJSONObject(0);
                                name = job.getString("user_name");
                                semail = job.getString("user_email");
                                phone = job.getString("user_phone");
                                spassword = job.getString("user_password");
                                if (semail.contains(email) && spassword.contains(password)) {


                                    SharedPreferences sp = getApplicationContext().getSharedPreferences
                                            ("com.ecommerce.mronlineshop", Context.MODE_PRIVATE);
                                    sp.edit().putString("user_name", name).apply();
                                    sp.edit().putString("user_email", semail).apply();
                                    sp.edit().putString("user_phone", phone).apply();
                                    sp.edit().putString("user_password", spassword).apply();
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login_Activity.this, MainHome.class);
                                    startActivity(intent);
                                    finish();
                                    //Animatoo.animateSlideLeft(getApplicationContext());
                                } else {
                                    Toast.makeText(getApplicationContext(), "Your password or email is wrong", Toast.LENGTH_SHORT).show();
                                    Snackbar.make(view, "Your password or email is wrong.Try Again", Snackbar.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        requestQueue.stop();





                      //  startActivity(new Intent(Login_Activity.this,MainHome.class));
                       // finish();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_SHORT).show();
                       Snackbar.make(view,"Network Error.Try again",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                        requestQueue.stop();

                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }){
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();

                        params.put("user_email", email);
                        params.put("user_password",password);
                        return params;
                    }
                };


                requestQueue.add(stringRequest);




            }
        });

    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
           // window.setStatusBarColor(Color.TRANSPARENT);
             window.setStatusBarColor(getResources().getColor(R.color.regisbk));
        }

    }


    public void registration(View view) {
        startActivity(new Intent(Login_Activity.this,RegistrationActivity.class));
    }

}