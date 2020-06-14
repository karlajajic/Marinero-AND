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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.marinero_kj.adapter.SightAdapter;
import com.example.marinero_kj.pojo.Sight;
import com.example.marinero_kj.viewModel.SightListViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SightListFragment extends Fragment implements SightAdapter.OnListItemClickListener {

    private RecyclerView mRecyclerView;
    private SightAdapter adapter;
    private ArrayList<Sight> sights;
    private SightListViewModel viewModel;

    private static final String USERNAME="username";
    private String username;

    public static SightListFragment newInstance(String username) {
        SightListFragment fragment = new SightListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(USERNAME, username);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SightListViewModel.class);
        String name="unknown";

        if(getArguments()!=null)
            name= getArguments().getString(USERNAME);
        username=name;

        sights=new ArrayList<>();
        List<Sight> s=viewModel.getAllSights().getValue();
        if(s!=null)
        for(Sight sigh:s)
            sights.add(sigh);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sight_list_fragment, container, false);

        mRecyclerView = view.findViewById(R.id.rv);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)); //so its a grid, not a list

        viewModel.getAllSights().observe(this, new Observer<List<Sight>>() {

            @Override
            public void onChanged(List<Sight> s) {
                if (!s.isEmpty()) {
                    sights.clear();
                    for(Sight sigh:s)
                        sights.add(sigh);
                }
                else populateSights();
            }
        });

        adapter = new SightAdapter(sights, this);
        mRecyclerView.setAdapter(adapter);
        return view;
    }

 //36.7201600,-4.4203400
    private void populateSights() {
        Sight s=new Sight("Split","Najlipši grad na svitu", true);
        s.setLongitude(36.7201600);
        s.setLatitude(-4.4203400);
        viewModel.addSight(s);

        s=new Sight("Pula","Pula je tamo negdi gore", true);
        s.setLongitude(35.6401600);
        s.setLatitude(-4.2303400);
        viewModel.addSight(s);

        s=new Sight("Zadar","Zadar je shema grad, blizu kuce", true);
        s.setLongitude(36.5001600);
        s.setLatitude(-4.5103400);
        viewModel.addSight(s);

        s=new Sight("Dubrovnik","Tamo di se snima game of thrones", true);
        s.setLongitude(37.5601600);
        s.setLatitude(-4.6003400);
        viewModel.addSight(s);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        //Toast.makeText(this.getContext(), sights.get(clickedItemIndex).getName(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getActivity(), CityDetail.class);
        intent.putExtra("sight",sights.get(clickedItemIndex));
        intent.putExtra("username",username);
        startActivity(intent);
    }
}
