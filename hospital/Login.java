package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Login extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout register_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register_layout = findViewById(R.id.register_layout);
        init();
    }

    private void init() {
        register_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
//        finish();
    }
}