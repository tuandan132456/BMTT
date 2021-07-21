package com.example.badiem.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.badiem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HistoryCard extends RecyclerView.Adapter<HistoryCard.FeaturedViewHoder> {

    ArrayList<HistoryHelpersClass> featuredLocations;
    DatabaseReference databaseReference;

    public HistoryCard(ArrayList<HistoryHelpersClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_history,parent,false);
        FeaturedViewHoder featuredViewHoder = new FeaturedViewHoder(view);
        return featuredViewHoder;
    }


    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHoder holder, int position) {

        HistoryHelpersClass featuredHelpersClass = featuredLocations.get(position);

        holder.textuser.setText(featuredHelpersClass.getUsername());
        holder.textaction.setText(featuredHelpersClass.getActionname());
        holder.textdate.setText(featuredHelpersClass.getDatetime());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public class FeaturedViewHoder extends RecyclerView.ViewHolder{

        ImageView image, title, dele;
        TextView textuser,textaction,textdate;
        Switch aSwitch;


        public FeaturedViewHoder(@NonNull View itemView) {
            super(itemView);
            //databaseReference = FirebaseDatabase.getInstance().getReference("User");
            textuser = itemView.findViewById(R.id.usernameHistory);
            textaction = itemView.findViewById(R.id.actionHistory);
            textdate = itemView.findViewById(R.id.dateHistory);
            itemView.bringToFront();


        }
    }
}
