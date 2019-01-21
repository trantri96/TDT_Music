package com.trantri.tdt_music.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.trantri.tdt_music.Activity.SongsListActivity;
import com.trantri.tdt_music.Model.Playlist;
import com.trantri.tdt_music.Model.PlaylistAll;
import com.trantri.tdt_music.R;
import java.util.ArrayList;

public class DanhSachAllPlaylistAdapter extends RecyclerView.Adapter<DanhSachAllPlaylistAdapter.ViewHolder> {
    Context mContext;
    ArrayList<PlaylistAll> list;

    public DanhSachAllPlaylistAdapter(Context mContext, ArrayList<PlaylistAll> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item_allplaylist, parent, false);
        ViewHolder mViewHolder = new ViewHolder(v);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlaylistAll playlist = list.get(position);
        // ??? getHinhAnhPlaylist = null
        Picasso.with(mContext).load(list.get(position).getHinhNen()).into(holder.imgView);
        holder.txtTenDanhSachBH.setText(playlist.getTen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtTenDanhSachBH;

        public ViewHolder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img_danhsachallBH);
            txtTenDanhSachBH = itemView.findViewById(R.id.tv_danhsachallplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, SongsListActivity.class);
                    intent.putExtra("itemPlaylistAll", list.get(getPosition()));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
