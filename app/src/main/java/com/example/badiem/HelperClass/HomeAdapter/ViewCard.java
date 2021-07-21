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
import com.example.badiem.UserData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewCard extends RecyclerView.Adapter<ViewCard.FeaturedViewHoder> {

    ArrayList<FeaturedHelpersClass> featuredLocations;
    DatabaseReference databaseReference;
    List<HistoryHelpersClass> userData;
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
            databaseReference = FirebaseDatabase.getInstance().getReference("User");
            image = itemView.findViewById(R.id.avatar);
            title = itemView.findViewById(R.id.btnedit);
            desc = itemView.findViewById(R.id.btndelete);
            text =  itemView.findViewById(R.id.txtProfileUsername);
            aSwitch = itemView.findViewById(R.id.btnswitch);
            itemView.bringToFront();
            desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getAdapterPosition();
                    FeaturedHelpersClass item = featuredLocations.get(itemPosition);
                    //Toast.makeText(v.getContext(),"The Item Clicked is: "+item.getUsername(),Toast.LENGTH_SHORT).show();

                    databaseReference.child(item.getUsername()).removeValue();
                    Toast.makeText(v.getContext(), "Successfully deleted user: "+item.getUsername(), Toast.LENGTH_SHORT).show();

                    //v.getContext().startActivity(get);
                    //final Intent intent;
                    //intent =  new Intent(v.getContext(), History.class);
                    //v.getContext().startActivity(intent);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getAdapterPosition();
                    userData = new ArrayList<>();
                    FeaturedHelpersClass item = featuredLocations.get(itemPosition);
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });

        }
    }
}
