package com.example.marinero_kj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CityDetails extends AppCompatActivity {

    FloatingActionButton fab;
    TextView sightTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

//        sightTitle=findViewById(R.id.sight_title);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("sightName");
//        if(data!=null)
//            sightTitle.setText(data);

        fab = findViewById(R.id.fab);
    }


    public void fabClicked(View view) {
        Toast.makeText(getApplicationContext(), R.string.like_town, Toast.LENGTH_LONG).show();
//        Snackbar.make(view, "You've clicked on FAB",
//                Snackbar.LENGTH_LONG).show();
        fab.setImageResource(R.drawable.ic_fab_fav_fill);
    }

}
