package com.ecommerce.mronlineshop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ecommerce.mronlineshop.R;
import com.ecommerce.mronlineshop.models.BanarAdaptar;
import com.ecommerce.mronlineshop.models.Banar_Model;
import com.ecommerce.mronlineshop.models.CatAdapter;
import com.ecommerce.mronlineshop.models.CatagoryModel;
import com.ecommerce.mronlineshop.models.Great_offerAdapter;
import com.ecommerce.mronlineshop.models.Great_offer_model;
import com.ecommerce.mronlineshop.models.PlatModel;
import com.ecommerce.mronlineshop.models.Plate_Adapter;
import com.ecommerce.mronlineshop.models.SimpleAdapter;
import com.ecommerce.mronlineshop.models.Simple_product_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewOrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewOrderFragment newInstance(String param1, String param2) {
        NewOrderFragment fragment = new NewOrderFragment();
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
//Catagory


    private RecyclerView recyclerView,banarRecycler,simplerecycler,greatOffer_recycler,greatoffer_verticle_recyclerview,newarrivalVerticle,newarrivalhorizontal
            ,mrshop_horizontal,mrshop_verticle;
    private CatAdapter catAdapter;

    private List<Banar_Model> banarlist;
    private List<Simple_product_model> simplemodel;
    private List<Great_offer_model> great_offer_models;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_new_order, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerViewcatagory);
        banarRecycler=(RecyclerView)view.findViewById(R.id.banar_recyclerView);
        simplerecycler=(RecyclerView)view.findViewById(R.id.simple_recyclerView);
        greatOffer_recycler=(RecyclerView)view.findViewById(R.id.great_offer_recyclerView);
        greatoffer_verticle_recyclerview=(RecyclerView)view.findViewById(R.id.greatoffer_recyclerView_verticle);
        newarrivalVerticle=(RecyclerView)view.findViewById(R.id.newarrival_recyclerView_verticle);
        newarrivalhorizontal=(RecyclerView)view.findViewById(R.id.newarrival_recyclerView_horizontal);
        mrshop_horizontal=(RecyclerView)view.findViewById(R.id.mrshop_recyclerView_horizontal);
        mrshop_verticle=(RecyclerView)view.findViewById(R.id.mrshop_recyclerView_verticle);

        init();
        banarRe();
        simpleRecycler();
        greatOffer();
        arrivalview();
        mrshopver();
        mrshophor();
        return view;
    }

    private void mrshopver() {
        LinearLayoutManager layoutManagerban=new LinearLayoutManager(getContext());
        layoutManagerban.setOrientation(RecyclerView.VERTICAL);
        mrshop_verticle.setLayoutManager(layoutManagerban);
        simplemodel=new ArrayList<>();

        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        SimpleAdapter simpleAdapter =new SimpleAdapter(getContext(),simplemodel);
        mrshop_verticle.setAdapter(simpleAdapter);
        simpleAdapter.notifyDataSetChanged();

    }

    private void mrshophor() {
        LinearLayoutManager layoutManagergreat=new LinearLayoutManager(getContext());
        layoutManagergreat.setOrientation(RecyclerView.HORIZONTAL);
        mrshop_horizontal.setLayoutManager(layoutManagergreat);
        great_offer_models=new ArrayList<>();
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"নূর কনফেকশনারি","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Home Plus Super Shop","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Nagar Bazar","1h","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"নূর কনফেকশনারি","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Home Plus Super Shop","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Nagar Bazar","1h","20%","3.5"));
        Great_offerAdapter banarAdaptar=new Great_offerAdapter(getContext(),great_offer_models);
        mrshop_horizontal.setAdapter(banarAdaptar);
        banarAdaptar.notifyDataSetChanged();

    }

    private Plate_Adapter plate_adapter;
    private void init() {
        final  List<CatagoryModel> list;
         String link="https://mrshop2001.000webhostapp.com/mshop/ajax/API/catagories.php";
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        list=new ArrayList<>();
        final String pic;

        final RequestQueue requestQueue= Volley.newRequestQueue(view.getContext());
        // Showing progress dialog before making http request
        StringRequest stringRequest=new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("catagories");
                    for (int i = 0; i < jsonArray.length(); i++) {
                       CatagoryModel p=new CatagoryModel();
                        JSONObject job=jsonArray.getJSONObject(i);
                        p.setCat_img(job.getString("cat_image"));
                        p.setCat_title(job.getString("cat_title"));
                        list.add(p);
                    }
                    catAdapter=new CatAdapter(view.getContext(),list);
                    recyclerView.setAdapter(catAdapter);
                    catAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(view.getContext(),"Network Error",Toast.LENGTH_SHORT).show();

                requestQueue.stop();
            }

        });
        requestQueue.add(stringRequest);




        CatAdapter cata=new CatAdapter(getContext(),list);
        recyclerView.setAdapter(cata);
       cata.notifyDataSetChanged();

    }
    ////////////////////////////////////////////Banar RecyclerView Start//////////////////////////////////////////////
    private void banarRe() {
        String banlink="https://mrshop2001.000webhostapp.com/mshop/ajax/API/banner.php";
        LinearLayoutManager layoutManagerbansim=new LinearLayoutManager(getContext());
        layoutManagerbansim.setOrientation(RecyclerView.HORIZONTAL);
        banarRecycler.setLayoutManager(layoutManagerbansim);
        banarlist=new ArrayList<>();
        final RequestQueue requestQueue= Volley.newRequestQueue(view.getContext());
        // Showing progress dialog before making http request
        StringRequest stringRequest=new StringRequest(Request.Method.POST, banlink, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplication(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("banner");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Banar_Model ban=new Banar_Model();
                        JSONObject job=jsonArray.getJSONObject(i);
                        ban.setBanar_img(job.getString("banner_img"));
                        banarlist.add(ban);

                    }
                    BanarAdaptar banarAdaptar=new BanarAdaptar(getContext(),banarlist);
                    banarRecycler.setAdapter(banarAdaptar);
                    banarAdaptar.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(view.getContext(),"Network Error",Toast.LENGTH_SHORT).show();

                requestQueue.stop();
            }

        });
        requestQueue.add(stringRequest);




    }


    ///////////////////////////////////////////////////Bannar RecyclerView End///////////////////////////////

    /////////////////////////////////Simple RecyclerView Start//////////////////////////////////////////

    private void simpleRecycler() {
        LinearLayoutManager layoutManagerban=new LinearLayoutManager(getContext());
        layoutManagerban.setOrientation(RecyclerView.VERTICAL);
        simplerecycler.setLayoutManager(layoutManagerban);
       simplemodel=new ArrayList<>();

        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
        ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        SimpleAdapter simpleAdapter =new SimpleAdapter(getContext(),simplemodel);
       simplerecycler.setAdapter(simpleAdapter);
        simpleAdapter.notifyDataSetChanged();
        ///////////////////////////////  Great offer Recycler view verticle /////////////////////////////


        LinearLayoutManager layoutManagerbanre=new LinearLayoutManager(getContext());
        layoutManagerbanre.setOrientation(RecyclerView.VERTICAL);
        greatoffer_verticle_recyclerview.setLayoutManager(layoutManagerbanre);
        simplemodel=new ArrayList<>();

        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        SimpleAdapter simpleAdaptera =new SimpleAdapter(getContext(),simplemodel);
        greatoffer_verticle_recyclerview.setAdapter(simpleAdaptera);
        simpleAdapter.notifyDataSetChanged();



        ///////////////////////////////////////new arrival verticle///////////////////////////////////

         layoutManagerbanre=new LinearLayoutManager(getContext());
        layoutManagerbanre.setOrientation(RecyclerView.VERTICAL);
        newarrivalVerticle.setLayoutManager(layoutManagerbanre);
        simplemodel=new ArrayList<>();

        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simplemodel.add(new Simple_product_model(R.drawable.simple_product_pic,"Accer Aspire-5 A51","9th Gen Acer Nitro 5 15.6″ FHD IPS Laptop Black I5-93"
                ,"৳ 78,900","5.5","20% OFF-Use code ZOMATO","BrandAcerSKU114750556 BD-103254613"));
        simpleAdaptera =new SimpleAdapter(getContext(),simplemodel);
        newarrivalVerticle.setAdapter(simpleAdaptera);
        simpleAdapter.notifyDataSetChanged();










    }
    //////////////////////////////   simple Recycler View Finished  ////////////////////////////////////////

    private void greatOffer() {
        LinearLayoutManager layoutManagergreat=new LinearLayoutManager(getContext());
        layoutManagergreat.setOrientation(RecyclerView.HORIZONTAL);
        greatOffer_recycler.setLayoutManager(layoutManagergreat);
        great_offer_models=new ArrayList<>();
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"নূর কনফেকশনারি","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Home Plus Super Shop","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Nagar Bazar","1h","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"নূর কনফেকশনারি","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Home Plus Super Shop","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Nagar Bazar","1h","20%","3.5"));
        Great_offerAdapter banarAdaptar=new Great_offerAdapter(getContext(),great_offer_models);
        greatOffer_recycler.setAdapter(banarAdaptar);
        banarAdaptar.notifyDataSetChanged();

        /////////////////////////////////////  new arrival horizontal  //////////////////////////////////////////
        LinearLayoutManager layoutManagerarrivalhori=new LinearLayoutManager(getContext());
        layoutManagerarrivalhori.setOrientation(RecyclerView.HORIZONTAL);
        newarrivalhorizontal.setLayoutManager(layoutManagerarrivalhori);
        great_offer_models=new ArrayList<>();
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"নূর কনফেকশনারি","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Home Plus Super Shop","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Nagar Bazar","1h","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"নূর কনফেকশনারি","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Home Plus Super Shop","50 min","20%","3.5"));
        great_offer_models.add(new Great_offer_model(R.drawable.banner_great_offer,"Nagar Bazar","1h","20%","3.5"));
       banarAdaptar=new Great_offerAdapter(getContext(),great_offer_models);
        newarrivalhorizontal.setAdapter(banarAdaptar);
        banarAdaptar.notifyDataSetChanged();










    }

    private void arrivalview() {





    }



}