package com.example.hospital;

import android.content.Context;
import android.graphics.pdf.PdfDocument;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class Adapter extends FragmentStatePagerAdapter {
    int Tabcount ;
    private Context mycontext;
    public Adapter(Context context, @NonNull FragmentManager fm, int tabcount) {
        super(fm);
        mycontext = context;
        this.Tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                cardiology cardiology = new cardiology();
                return cardiology;
            case 1:
                Padiatrics padiatrics = new Padiatrics();
                return padiatrics;
            case 2:
                Pulmonary pulmonary = new Pulmonary();
                return pulmonary;
            case 3:
                Urology urology = new Urology();
                return urology;

            case 4:
                Traumatology traumatology = new Traumatology();
                return traumatology;
            case 5:
                Neurology neurology = new Neurology();
                return neurology;

            default:
            return null;
        }
        }


    @Override
    public int getCount() {

        return Tabcount;
    }
}
