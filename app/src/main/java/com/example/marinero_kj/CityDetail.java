package com.example.marinero_kj;

import android.os.Bundle;

import com.example.marinero_kj.pojo.Sight;
import com.example.marinero_kj.adapter.CityDetailFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;


public class CityDetail extends AppCompatActivity {

    private Sight sight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        String username="unknown";

        //dodano -> vrati na normalno kasnije
        if(getIntent().hasExtra("sight")) {
            Bundle bundle = getIntent().getExtras();
            sight = (Sight)bundle.getSerializable("sight");
            username= (String)bundle.getString("username");
            TextView textView = findViewById(R.id.city_detail_city_name);
            textView.setText(sight.getName());
        }

        CityDetailFragmentPagerAdapter sectionsPagerAdapter = new CityDetailFragmentPagerAdapter(this, getSupportFragmentManager(), sight, username);
        ViewPager viewPager = findViewById(R.id.city_detail_view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.city_detail_tabs);
        tabs.setupWithViewPager(viewPager);

    }
}