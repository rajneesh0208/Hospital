package com.example.hospital;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AppointmentAdapter extends FragmentStatePagerAdapter {
    int Tabcount;
    private Context mycontext;
    public AppointmentAdapter(Context context, @NonNull FragmentManager fm, int tabcount) {
        super(fm);
        mycontext = context;
        this.Tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Upcoming upcoming = new Upcoming();
                return upcoming;
            case 1:
                Past past = new Past();
                return past;
                        default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return Tabcount;
    }
}
