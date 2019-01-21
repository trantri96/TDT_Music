package com.trantri.tdt_music.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trantri.tdt_music.Activity.DanhSachAllAlbumActivity;
import com.trantri.tdt_music.Adapter.AlbumAdapter;
import com.trantri.tdt_music.Model.Album;
import com.trantri.tdt_music.R;
import com.trantri.tdt_music.Service.APIService;
import com.trantri.tdt_music.Service.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentAlbum extends Fragment {
    View view;
RecyclerView mRecyclerView;
TextView txtXemThemAlbum;
AlbumAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container, false);
        initview();
        GetDataAlbum();
        return view;
    }

    private void initview() {
    mRecyclerView = view.findViewById(R.id.myRecycleAlbum);
    txtXemThemAlbum = view.findViewById(R.id.tv_xemthemAlbum);
    txtXemThemAlbum.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), DanhSachAllAlbumActivity.class);
            startActivity(intent);
        }
    });
    }

    private void GetDataAlbum() {
        DataService mDataService = APIService.getService();
        Call<List<Album>> mCall = mDataService.getDataAlbum();
        mCall.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albumList = response.body();
                     mAdapter = new AlbumAdapter(getActivity(), albumList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
