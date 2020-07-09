package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class Doctor_profile extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tableLayout = findViewById(R.id.tab_layout);
        tableLayout.addTab(tableLayout.newTab().setText("Cardiology"));
        tableLayout.addTab(tableLayout.newTab().setText("Padiatrics"));
        tableLayout.addTab(tableLayout.newTab().setText("Pulmonary"));
        tableLayout.addTab(tableLayout.newTab().setText("Urology"));
        tableLayout.addTab(tableLayout.newTab().setText("Traumatology"));
        tableLayout.addTab(tableLayout.newTab().setText("Neurology"));
        tableLayout.setTabGravity(TabLayout.GRAVITY_FILL);




        viewPager = findViewById(R.id.viewpager);
        Adapter adapter = new Adapter(this,getSupportFragmentManager(), tableLayout.getTabCount());
        viewPager.setAdapter(adapter);

//        tableLayout.setupWithViewPager(viewPager);

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
        }

    public void setSupportActionBar(Toolbar toolbar) {
    }

}