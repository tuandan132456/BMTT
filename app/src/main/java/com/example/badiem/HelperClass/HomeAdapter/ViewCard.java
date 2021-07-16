package com.example.badiem.HelperClass.HomeAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.badiem.R;

import java.util.ArrayList;

public class ViewCard extends RecyclerView.Adapter<ViewCard.FeaturedViewHoder> {

    ArrayList<FeaturedHelpersClass> featuredLocations;

    public ViewCard(ArrayList<FeaturedHelpersClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_show,parent,false);
        FeaturedViewHoder featuredViewHoder = new FeaturedViewHoder(view);
        return featuredViewHoder;
    }


    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHoder holder, int position) {

        FeaturedHelpersClass featuredHelpersClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelpersClass.getImage());
        holder.text.setText(featuredHelpersClass.getUsername());
        holder.title.setImageResource(featuredHelpersClass.getImage1());
        holder.desc.setImageResource(featuredHelpersClass.getImage2());
        holder.aSwitch.setChecked(featuredHelpersClass.getaSwitch());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public class FeaturedViewHoder extends RecyclerView.ViewHolder{

        ImageView image, title, desc;
        TextView text;
        Switch aSwitch;


        public FeaturedViewHoder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.avatar);
            title = itemView.findViewById(R.id.btnedit);
            desc = itemView.findViewById(R.id.btndelete);
            text =  itemView.findViewById(R.id.txtProfileUsername);
            aSwitch = itemView.findViewById(R.id.btnswitch);
            itemView.bringToFront();

        }
    }
}
