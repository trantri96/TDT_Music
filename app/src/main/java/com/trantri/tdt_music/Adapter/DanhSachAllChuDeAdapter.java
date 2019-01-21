package com.trantri.tdt_music.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.trantri.tdt_music.Activity.DanhSachTheLoaiTheoChuDeActivity;
import com.trantri.tdt_music.Activity.SongsListActivity;
import com.trantri.tdt_music.Model.ChuDe;
import com.trantri.tdt_music.R;

import java.util.List;

public class DanhSachAllChuDeAdapter extends RecyclerView.Adapter<DanhSachAllChuDeAdapter.ViewHolder> {
    Context mContext;
    List<ChuDe> mList;

    public DanhSachAllChuDeAdapter(Context mContext, List<ChuDe> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item_cac_chu_de, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ChuDe chuDe = mList.get(position);

        Picasso.with(mContext).load(chuDe.getHinhChuDe()).into(holder.imgChuDe);
        holder.imgChuDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DanhSachTheLoaiTheoChuDeActivity.class);
                intent.putExtra("chude", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgChuDe;

        public ViewHolder(View itemView) {
            super(itemView);
            imgChuDe = itemView.findViewById(R.id.img_allChuDe);

        }
    }
}
