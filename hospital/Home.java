package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private static final String MY_PREFS_NAME = "Hospital";
    RelativeLayout setting_layout,home_layout,appointment_layout,chat_layout,book_appointment;
    ImageView setting,home,chat,appointment;
    TextView txt_home,txt_chat,txt_setting,txt_appointment,category_all;
    private View view;
    RecyclerView recycleview_home_doctorlist;
    ArrayList<homedoctorlist_getset> homedoctorlist;
    private String TAG = "home";
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setting_layout = findViewById(R.id.setting_layout);
        setting  = findViewById(R.id.setting);
        txt_setting = findViewById(R.id.txt_setting);

        mQueue = Volley.newRequestQueue(this);

        chat_layout = findViewById(R.id.chat_layout);
        chat = findViewById(R.id.chat);
        txt_chat = findViewById(R.id.txt_chat);

        home = findViewById(R.id.home);
        txt_home = findViewById(R.id.txt_home);
        home_layout = findViewById(R.id.home_layout);

        recycleview_home_doctorlist = findViewById(R.id.recycleview_home_doctorlist);
        recycleview_home_doctorlist.setHasFixedSize(true);

        appointment_layout = findViewById(R.id.appointment_layout);
        appointment = findViewById(R.id.appointment);
        txt_appointment = findViewById(R.id.txt_appointment);
        
        SharedPreferences prefs1 = getSharedPreferences( MY_PREFS_NAME, MODE_PRIVATE );
        String userId1 = prefs1.getString("userid", null);

        home.setImageResource(R.drawable.home_active);
        txt_home.setTextColor(getResources().getColor(R.color.activeColor));
        init();
       new homedoctorlist.execute();
    }

    public class homedoctorlist extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            URL url;

            try {
                url = new URL("https://freaktemplate.com/singleclinic/api/listofdoctorbydepartment?department_id="+"userId1");
                Log.d("URL","" + url);

                URLConnection hpCon = url.openConnection();
                hpCon.connect();
                InputStream input = hpCon.getInputStream();
                Log.d( "input", "" + input );
                BufferedReader r = new BufferedReader( new InputStreamReader( input ) );
                String x;
                x = r.readLine();
                StringBuilder total = new StringBuilder();
                while (x != null) {
                    total.append( x );
                    x = r.readLine();
                }
                Log.d( "URL", "" + total );

                JSONObject jsonObject = new JSONObject(total.toString());
                    JSONArray data = jsonObject.getJSONArray("data");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }



        public static class execute {
        }
    }

//    private void homedoctorlist() {
//
//        RequestQueue requestQueue;
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
//        Network network = new BasicNetwork(new HurlStack());
//
//
//        requestQueue = new RequestQueue(cache, network);
//        requestQueue.start();
//
//        String url = "https://freaktemplate.com/singleclinic/api/listofdoctorbydepartment?department_id=1" ;
//
//        homedoctorlist =new ArrayList<>();
////        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
////            @Override
////            public void onResponse(JSONObject response) {
////                try {
////                    JSONObject jsonObject = new JSONObject("data");
////                    JSONArray data = jsonObject.getJSONArray("data");
////                    for (int i = 0; i < data.length(); i++) {
////
////                        JSONObject jsonObject1 = data.getJSONObject(i);
////                        String doctorname = jsonObject1.getString("name");
////                        String doctorimage = jsonObject1.getString("image");
//////                        String departmentnme = jsonObject1.getString("department_id");
////                        String description = jsonObject1.getString("about_us");
////
////                        homedoctorlist_getset homedoctorlist_getset = new homedoctorlist_getset();
//////                        homedoctorlist_getset.setDepartmentnme(departmentnme);
////                        homedoctorlist_getset.setDoctorname(doctorname);
////                        homedoctorlist_getset.setDoctorimage(doctorimage);
////                        homedoctorlist_getset.setDescription(description);
////                        homedoctorlist.add(homedoctorlist_getset);
////
////                    }
////                    setHomeAdapter();
////
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
////            }
////        }, new Response.ErrorListener() {
////            @Override
////            public void onErrorResponse(VolleyError error) {
////                error.printStackTrace();
////            }
////        });
////
////        mQueue.add(request);
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e(TAG, "onResponse: " + response );
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONObject data  =jsonObject.getJSONObject("data");
//                    JSONArray data1 = data.getJSONArray("data");
//
//                    for (int i = 0; i <data1.length() ; i++) {
//                        JSONObject jsonObject1 = data1.getJSONObject(i);
//                        String doctorname = jsonObject1.getString("name");
//                        String doctorimage = jsonObject1.getString("image");
////                        String departmentnme = jsonObject1.getString("department_id");
//                        String description = jsonObject1.getString("about_us");
//
//                        homedoctorlist_getset homedoctorlist_getset = new homedoctorlist_getset();
////                        homedoctorlist_getset.setDepartmentnme(departmentnme);
//                        homedoctorlist_getset.setDoctorname(doctorname);
//                        homedoctorlist_getset.setDoctorimage(doctorimage);
//                        homedoctorlist_getset.setDescription(description);
//                        homedoctorlist.add(homedoctorlist_getset);
//
//                    }
//
//                    setHomeAdapter();
//
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: "+ error.getMessage() );
//            }
//        });
//            requestQueue.add(stringRequest);
//    }

    private void setHomeAdapter(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview_home_doctorlist.setHasFixedSize(true);

        recycleview_home_doctorlist.setNestedScrollingEnabled(false);
        recycleview_home_doctorlist.setLayoutManager(layoutManager);
        HomeAdapter adapter = new HomeAdapter(homedoctorlist,this);
        recycleview_home_doctorlist.setAdapter(adapter);

    }
    private void init() {
        setting_layout.setOnClickListener(this);
        chat_layout.setOnClickListener(this);
        appointment_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
        switch (v.getId()) {
            case R.id.setting_layout:
                Intent intent = new Intent(Home.this, Setting.class);
                startActivity(intent);
//            finish();
                break;

            case  R.id.chat_layout:
                Intent intent1 = new Intent(Home.this, Chat.class);
                startActivity(intent1);
//            finish();
                break;

            case  R.id.appointment_layout:
                Intent intent2 = new Intent(Home.this, Appointment.class);
                startActivity(intent2);
//            finish();
                break;


        }

        }
    }
