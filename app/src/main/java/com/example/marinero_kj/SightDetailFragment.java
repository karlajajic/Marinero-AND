package com.example.marinero_kj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marinero_kj.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SightDetailFragment extends Fragment {

    TextView description;
    FloatingActionButton favoriteButton;

    private static final String DESCRIPTION="description";
    private static String descriptionValue;

    public static SightDetailFragment newInstance(String description) {
        SightDetailFragment fragment = new SightDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DESCRIPTION, description);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null)
            descriptionValue=getArguments().getString(DESCRIPTION);
        else descriptionValue="error";
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sight_detail, container, false);

        description= view.findViewById(R.id.sight_detail_text);
        description.setText(descriptionValue);

        favoriteButton=view.findViewById(R.id.fragment_sight_detail_fab);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.like_town, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}