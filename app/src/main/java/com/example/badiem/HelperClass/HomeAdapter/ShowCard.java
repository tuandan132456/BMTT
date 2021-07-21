package com.example.badiem.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.badiem.R;

import java.util.ArrayList;

public class ShowCard extends RecyclerView.Adapter<ShowCard.FeaturedViewHolder> {

    public ArrayList<FeaturedHelpersClass>featuredLocations;

    public ShowCard(ArrayList<FeaturedHelpersClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelpersClass featuredHelpersClass = featuredLocations.get(position);

        holder.image.setImageResource(featuredHelpersClass.getImage());
        holder.username.setText(featuredHelpersClass.getUsername());
        holder.image1.setImageResource(featuredHelpersClass.getImage1());
        holder.image2.setImageResource(featuredHelpersClass.getImage2());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView username;
        ImageView image1, image2;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.txtProfileUsername);
            image1 = itemView.findViewById(R.id.btnedit);
            image2 = itemView.findViewById(R.id.btndelete);
        }
    }

}
