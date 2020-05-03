package com.example.marinero_kj;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.marinero_kj.adapter.SightAdapter;
import com.example.marinero_kj.pojo.Sight;

import java.util.ArrayList;

public class SightListFragment extends Fragment implements SightAdapter.OnListItemClickListener {

    private RecyclerView mRecyclerView;
    private SightAdapter adapter;
    private ArrayList<Sight> sights;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sight_list_fragment, container, false);

        mRecyclerView = view.findViewById(R.id.rv);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        sights=new ArrayList<Sight>();
        populateSights();

        adapter = new SightAdapter(sights, this);
        mRecyclerView.setAdapter(adapter);
        return view;
    }
 //36.7201600,-4.4203400
    private void populateSights() {
        Sight s=new Sight("Split","Najlipši grad na svitu", true);
        s.setLongitude(36.7201600);
        s.setLatitude(-4.4203400);
        sights.add(s);
        sights.add(new Sight("Pula","bla bla bla", true));
        sights.add(new Sight("Zadar","bla bla bla", true));
        sights.add(new Sight("Dubrovnik","bla bla bla", true));
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(this.getContext(), sights.get(clickedItemIndex).getName(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getActivity(), CityDetail.class);
        intent.putExtra("sight",sights.get(clickedItemIndex));
        startActivity(intent);
    }
}
