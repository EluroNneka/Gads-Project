package com.nneka.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;
import java.util.List;

public class SRecyclerAdapter extends RecyclerView.Adapter<SRecyclerAdapter.ViewHolder> {
    private Context mContext;
    private List<LSkills> mLSkillsList;
    private LayoutInflater mLayoutInflater;
    private String mImageUrl;

    public SRecyclerAdapter(Context context, List<LSkills> LSkillsList) {
        mContext = context;
        mLSkillsList = LSkillsList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.recycler_itemlist_skills,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SRecyclerAdapter.ViewHolder holder, int position) {
        LSkills skills = mLSkillsList.get(position);
        holder.mLeaderNames.setText(skills.getName());
        holder.mLeaderSkills.setText(skills.getSkills());
        holder.mLeaderCountrys.setText(skills.getCountry());
        mImageUrl = skills.getImage();
       Picasso.with(mContext).load(mImageUrl).into(holder.mImages);
        holder.mPositions = position;


    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mLeaderNames;
        public TextView mLeaderSkills;
        public TextView mLeaderCountrys;
        public ImageView mImages;
        public int mPositions;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
