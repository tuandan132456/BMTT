package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.badiem.HelperClass.HomeAdapter.FeaturedHelpersClass;
import com.example.badiem.HelperClass.HomeAdapter.ShowCard;
import com.example.badiem.HelperClass.HomeAdapter.ViewCard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ListUser extends AppCompatActivity {

    RecyclerView featuredRecycler;
    ViewCard adapter;
    Switch aSwitch ;
    DatabaseReference databaseReference;
    List<UserData> userData;
    ImageView back,edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list);


        featuredRecycler = findViewById(R.id.featred_recyclerrr);

        //featuredRecycler();
        aSwitch = findViewById(R.id.btnswitch);

        ArrayList list = new ArrayList<>();
        userData = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        //Query checkUser = databaseReference.orderByChild("username").getRef();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<FeaturedHelpersClass> featuredLocations = new ArrayList<>();
                featuredRecycler.setHasFixedSize(true);
                featuredRecycler.setLayoutManager(new LinearLayoutManager(ListUser.this, LinearLayoutManager.VERTICAL,false));

                for(DataSnapshot ds: snapshot.getChildren()){
                    UserData data = ds.getValue(UserData.class);
                    //helpersClasses.add(data);
                    userData.add(data);
                    String userDB = data.getUsername();
                    String username = snapshot.child("username").getKey();//.getValue(String.class);
                    System.out.println("Username: " + userDB);
                   // list.add(username);
                    featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, userDB, R.drawable.imgedit, R.drawable.imgdelete, aSwitch));

                }
                adapter = new ViewCard(featuredLocations);
                featuredRecycler.setAdapter(adapter);
                //onRestart();
                //
                //adapter = new ViewCard(helpersClasses);
                //featuredRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back = findViewById(R.id.useerback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
/* private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        ArrayList<FeaturedHelpersClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, "deathcoi", R.drawable.imgedit, R.drawable.imgdelete, aSwitch));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, "dancasi", R.drawable.imgedit, R.drawable.imgdelete, aSwitch));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, "danhayhat", R.drawable.imgedit, R.drawable.imgdelete, aSwitch));

        adapter = new ViewCard(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }*/
}