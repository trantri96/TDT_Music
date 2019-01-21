package com.trantri.tdt_music.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trantri.tdt_music.Model.Playlist;
import com.trantri.tdt_music.R;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);

    }
    public class ViewHolder{
        TextView txtNamePlaylist;
        ImageView imgBackgroud, imgPlaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_playlist, null);
            mViewHolder = new ViewHolder();
            mViewHolder.txtNamePlaylist = convertView.findViewById(R.id.tv_NamePlaylist);
            mViewHolder.imgBackgroud = convertView.findViewById(R.id.img_backgroundPlaylist);
            mViewHolder.imgPlaylist = convertView.findViewById(R.id.img_Playlist);
        convertView.setTag(mViewHolder);
        }
        else {
            mViewHolder = (ViewHolder) convertView.getTag();

        }
        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhAnhPlaylist()).into(mViewHolder.imgBackgroud);
        Picasso.with(getContext()).load(playlist.getIcon()).into(mViewHolder.imgPlaylist);
        mViewHolder.txtNamePlaylist.setText(playlist.getTen());
        return convertView;
    }
}
