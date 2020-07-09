package com.example.hospital;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Appointment extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    RelativeLayout setting_layout,home_layout,appointment_layout,chat_layout;
    ImageView setting,home,chat,appointment;
    TextView txt_home,txt_chat,txt_setting,txt_appointment;


//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        setting_layout = findViewById(R.id.setting_layout);
        setting  = findViewById(R.id.setting);
        txt_setting = findViewById(R.id.txt_setting);

        chat_layout = findViewById(R.id.chat_layout);
        chat = findViewById(R.id.chat);
        txt_chat = findViewById(R.id.txt_chat);

        home = findViewById(R.id.home);
        txt_home = findViewById(R.id.txt_home);
        home_layout = findViewById(R.id.home_layout);



        txt_appointment = findViewById(R.id.txt_appointment);
        appointment = findViewById(R.id.appointment);

        appointment.setImageResource(R.drawable.calendar_active);
        txt_appointment.setTextColor(getResources().getColor(R.color.activeColor));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tableLayout = findViewById(R.id.tab_layout);
        tableLayout.addTab(tableLayout.newTab().setText("Upcoming"));
        tableLayout.addTab(tableLayout.newTab().setText("Past"));

        tableLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.viewpager);
        AppointmentAdapter adapter = new AppointmentAdapter(this,getSupportFragmentManager(), tableLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));

        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {



            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
                public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    
            init();

    }

    private void init() {

        setting_layout.setOnClickListener(this);
        chat_layout.setOnClickListener(this);
        home_layout.setOnClickListener(this);
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.setting_layout:
                Intent intent = new Intent(Appointment.this, Setting.class);
                startActivity(intent);
//            finish();
                break;

            case  R.id.chat_layout:
                Intent intent1 = new Intent(Appointment.this, Chat.class);
                startActivity(intent1);
//            finish();
                break;

            case  R.id.home_layout:
                Intent intent2 = new Intent(Appointment.this, Home.class);
                startActivity(intent2);
//            finish();
                break;


        }
    }
}
