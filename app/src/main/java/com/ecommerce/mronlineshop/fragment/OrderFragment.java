package com.ecommerce.mronlineshop.fragment;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ecommerce.mronlineshop.R;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    DrawerLayout drawerLayout;
    ImageView navigationBar,iv_logout;
    CircleImageView profilepic;
    LinearLayout bookmark,gold,yourOrder,favourite,helporder,address,about,report,feedback,rate;
    NavigationView navigationView;
    TextView profil_name,profile_email;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_order, container, false);
        onSetNavigationDrawerEvents();
        return view;

    }
    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) view.findViewById(R.id.navigationView);

        drawerLayout.openDrawer(GravityCompat.START);

        //Header part
        profil_name=(TextView)view.findViewById(R.id.tv_dashboardHeader_profileName);
        profile_email=(TextView)view.findViewById(R.id.tv_dashboardHeader_profileemail);
        profilepic=(CircleImageView)view.findViewById(R.id.iv_dashboardHeader_profilePicture);


        navigationBar = (ImageView)view. findViewById(R.id.navigationBar);
       bookmark = (LinearLayout) view.findViewById(R.id.ll_First);
       gold = (LinearLayout) view.findViewById(R.id.goldnav);
        yourOrder = (LinearLayout) view.findViewById(R.id.ll_Second);
        favourite = (LinearLayout) view.findViewById(R.id.ll_Third);
        helporder = (LinearLayout) view.findViewById(R.id.helporder);
        address = (LinearLayout) view.findViewById(R.id.address);
       about = (LinearLayout) view.findViewById(R.id.about);
        report = (LinearLayout) view.findViewById(R.id.ll_Fifth);
        feedback = (LinearLayout) view.findViewById(R.id.ll_Sixth);
        rate = (LinearLayout) view.findViewById(R.id.ll_Seventh);



        navigationBar.setOnClickListener(this);
       bookmark.setOnClickListener(this);
       gold.setOnClickListener(this);
        yourOrder.setOnClickListener(this);
        favourite.setOnClickListener(this);
        helporder.setOnClickListener(this);
        address.setOnClickListener(this);
        about.setOnClickListener(this);
       report.setOnClickListener(this);
       feedback.setOnClickListener(this);
        rate.setOnClickListener(this);

        //header
        profilepic.setOnClickListener(this);
        profil_name.setOnClickListener(this);
        profile_email.setOnClickListener(this);

        Glide.with(getContext()).load(R.drawable.email).into(profilepic);
        profil_name.setText("Mr Online Shop");
        profile_email.setText("support.mronlinshop@gmail.com");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.ll_First:
                showToast("Bookmarks");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.goldnav:
                showToast("Total Gold");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Second:
                showToast("Your Order");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Third:
                showToast("favourite");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.helporder:
                showToast("Online Help");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.about:
                showToast("About");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Fifth:
                showToast("Feedback");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Sixth:
                showToast("Report");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.address:
                showToast("address");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.ll_Seventh:
                showToast("Rate");
                drawerLayout.closeDrawer(navigationView, true);
                break;
/*
            default:
                showToast("Default");
                drawerLayout.closeDrawer(navigationView, true);
                break;*/

        }
    }

    private void showToast(String message){
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }




}