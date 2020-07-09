package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Chat extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout setting_layout,home_layout,appointment_layout,chat_layout;
    ImageView setting,home,chat,appointment;
    TextView txt_home,txt_chat,txt_setting,txt_appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        appointment_layout = findViewById(R.id.appointment_layout);

        setting_layout = findViewById(R.id.setting_layout);
        setting  = findViewById(R.id.setting);
        txt_setting = findViewById(R.id.txt_setting);

//        chat_layout = findViewById(R.id.chat_layout);
        chat = findViewById(R.id.chat);
        txt_chat = findViewById(R.id.txt_chat);

        home = findViewById(R.id.home);
        txt_home = findViewById(R.id.txt_home);
        home_layout = findViewById(R.id.home_layout);

        chat.setImageResource(R.drawable.chat_active);
        txt_chat.setTextColor(getResources().getColor(R.color.activeColor));

        init();
    }

    private void init() {

        home_layout.setOnClickListener(this);
        setting_layout.setOnClickListener(this);
        appointment_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_layout:
                Intent intent = new Intent(this, Setting.class);
                startActivity(intent);
//            finish();
                break;

            case  R.id.home_layout:
                Intent intent1 = new Intent(this, Home.class);
                startActivity(intent1);
//            finish();
                break;

            case  R.id.appointment_layout:
                Intent intent2 = new Intent(this, Appointment.class);
                startActivity(intent2);
//            finish();
                break;


        }
    }
}