package com.example.marinero_kj;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.marinero_kj.adapter.SightAdapter;
import com.example.marinero_kj.pojo.Sight;

import java.util.ArrayList;

public class SightListView extends AppCompatActivity implements SightAdapter.OnListItemClickListener{

    private RecyclerView sightList;
    private SightAdapter adapter;
    private ArrayList<Sight> sights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sight_list);

        sightList =  findViewById(R.id.recyclerViewMain);
        sightList .hasFixedSize();
        sightList .setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        sights= new ArrayList<>();
        populateList();

        adapter= new SightAdapter(sights, this);
        sightList.setAdapter(adapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(this, sights.get(clickedItemIndex).getName(), Toast.LENGTH_LONG).show();
    }

    private void populateList(){
        sights.add(new Sight("Split","bla bla bla", true));
        sights.add(new Sight("Pula","bla bla bla", true));
        sights.add(new Sight("Zadar","bla bla bla", true));
        sights.add(new Sight("Dubrovnik","bla bla bla", true));
    }
}
