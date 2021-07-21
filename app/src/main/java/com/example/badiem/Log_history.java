package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.badiem.HelperClass.HomeAdapter.FeaturedHelpersClass;
import com.example.badiem.HelperClass.HomeAdapter.HistoryCard;
import com.example.badiem.HelperClass.HomeAdapter.HistoryHelpersClass;
import com.example.badiem.HelperClass.HomeAdapter.ViewCard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Log_history extends AppCompatActivity {
    RecyclerView featuredRecycler;
    ImageView back;
    HistoryCard adapter;
    DatabaseReference databaseReference;
    List<HistoryHelpersClass> historyHelpersClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_history);
        featuredRecycler = findViewById(R.id.history_recycler);
        ArrayList list = new ArrayList<>();
        historyHelpersClasses = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("LOG_Data");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<HistoryHelpersClass> featuredLocations = new ArrayList<>();
                featuredRecycler.setHasFixedSize(true);
                featuredRecycler.setLayoutManager(new LinearLayoutManager(Log_history.this, LinearLayoutManager.VERTICAL,false));

                for(DataSnapshot list: snapshot.getChildren()){
                    HistoryHelpersClass data = list.getValue(HistoryHelpersClass.class);
                    //helpersClasses.add(data);
                    historyHelpersClasses.add(data);
                    String actionname = data.getActionname();
                    String datetime = data.getDatetime();
                    String username = data.getUsername();

                    String action = snapshot.child("actionname").getKey();//.getValue(String.class);
                    String date = snapshot.child("datetime").getKey();
                    System.out.println("Actionname: " + actionname);
                    System.out.println("Datetime: " + datetime);
                    // list.add(username);
                    featuredLocations.add(new HistoryHelpersClass(username,actionname,datetime));

                }
                adapter = new HistoryCard(featuredLocations);
                featuredRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        back = findViewById(R.id.historyback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}