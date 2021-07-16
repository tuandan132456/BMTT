package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.badiem.HelperClass.HomeAdapter.FeaturedHelpersClass;
import com.example.badiem.HelperClass.HomeAdapter.ShowCard;
import com.example.badiem.HelperClass.HomeAdapter.ViewCard;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    RecyclerView featuredRecycler;
    ViewCard adapter;
    Switch aSwitch ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list);

        featuredRecycler = findViewById(R.id.featred_recyclerrr);
        featuredRecycler();
        aSwitch = findViewById(R.id.btnswitch);

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        ArrayList<FeaturedHelpersClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, "deathcoi", R.drawable.imgedit, R.drawable.imgdelete, aSwitch));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, "dancasi", R.drawable.imgedit, R.drawable.imgdelete, aSwitch));
        featuredLocations.add(new FeaturedHelpersClass(R.drawable.avatarnon2, "danhayhat", R.drawable.imgedit, R.drawable.imgdelete, aSwitch));

        adapter = new ViewCard(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }
}