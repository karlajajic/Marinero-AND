package com.example.marinero_kj.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marinero_kj.R;
import com.example.marinero_kj.pojo.Sight;

import java.util.ArrayList;

public class SightAdapter extends RecyclerView.Adapter<SightAdapter.SightViewHolder>{

    final private OnListItemClickListener onListItemClickListener;
    private ArrayList<Sight> sights;

    public SightAdapter(ArrayList<Sight> sights, OnListItemClickListener onListItemClickListener){
        this.onListItemClickListener=onListItemClickListener;
        this.sights=sights;
    }

    @NonNull
    @Override
    public SightAdapter.SightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sight_card, parent, false);
        return new SightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SightAdapter.SightViewHolder holder, int position) {
        Sight s=sights.get(position);

        holder.sightName.setText(s.getName());
        if(s.isHearted())
            holder.sightName.setTextColor(Color.parseColor("#607D8B")); //for some reason there is problem with resources
        if(s.getImage()!=-1)
        holder.sightImage.setImageResource(s.getImage());
    }

    @Override
    public int getItemCount() {
        return sights.size();
    }

    public class SightViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView sightName;
        ImageView sightImage;
        //LinearLayout layout;

        public SightViewHolder(@NonNull View itemView) {
            super(itemView);
           // layout=itemView.findViewById(R.id.container);
            sightName=itemView.findViewById(R.id.sight_title);
            sightImage=itemView.findViewById(R.id.sight_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}
