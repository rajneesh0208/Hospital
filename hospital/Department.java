package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Department extends AppCompatActivity implements View.OnClickListener {
    CardView pediatrics_cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        pediatrics_cardview = findViewById(R.id.padiatrics_cardview);
        init();

    }

    private void init() {
        pediatrics_cardview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.padiatrics_cardview:
                Intent intent = new Intent(this,Doctor_profile.class);
                startActivity(intent);
//                finish();
        }

    }
}