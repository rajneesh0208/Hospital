package com.example.hospital;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewholder> {

    private ArrayList<homedoctorlist_getset> homedoctorlistgetsets;
    private Context context;

    public HomeAdapter(ArrayList<homedoctorlist_getset> homedoctorlistgetsets, Home home) {
        this.homedoctorlistgetsets = homedoctorlistgetsets;
        this.context = home;
    }

    @NonNull
    @Override
    public HomeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_doctorlist_view,null );
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        String doc_name = homedoctorlistgetsets.get(position).getDoctorname();
        String description = homedoctorlistgetsets.get(position).getDescription();
        String department = homedoctorlistgetsets.get(position).getDepartmentnme();
        String doc_img = homedoctorlistgetsets.get(position).getDoctorimage();
        holder.doc_name.setText(doc_name);
        holder.department.setText(department);
        holder.description.setText(description);
        Picasso.get().load(doc_img).fit().centerInside().into(holder.doc_img);
    }

    @Override
    public int getItemCount() {

        return homedoctorlistgetsets.size();
    }


    class Viewholder extends RecyclerView.ViewHolder {

        ImageView doc_img;
        TextView doc_name,description,department;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            doc_img = itemView.findViewById(R.id.doctor_image);
            doc_name = itemView.findViewById(R.id.doctor_name);
            description = itemView.findViewById(R.id.doctor_speciality);
            department = itemView.findViewById(R.id.department_name);
        }
    }
}