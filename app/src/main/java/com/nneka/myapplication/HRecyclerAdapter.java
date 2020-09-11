package com.nneka.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HRecyclerAdapter extends RecyclerView.Adapter<HRecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<LHours> mLHoursList;
    private LayoutInflater mLayoutInflater;
    private String mImageUrl;


    public HRecyclerAdapter(Context context, List<LHours> hoursList) {
        mContext = context;
        mLHoursList = hoursList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.recycler_itemlist,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LHours hour = mLHoursList.get(position);
        holder.mLeaderName.setText(hour.getName());
        holder.mLeaderHour.setText(hour.getHours());
        holder.mLeaderCountry.setText(hour.getCountry());
        mImageUrl = hour.getImage();
        Picasso.with(mContext).load(mImageUrl).into(holder.mImage);
        holder.mPosition = position;

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mLeaderName;
        public TextView mLeaderHour;
        public TextView mLeaderCountry;
        public ImageView mImage;
        public  int mPosition;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
