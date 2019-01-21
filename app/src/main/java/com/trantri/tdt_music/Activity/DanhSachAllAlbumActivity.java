package com.trantri.tdt_music.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.trantri.tdt_music.Adapter.DanhSachAllAlbumAdapter;
import com.trantri.tdt_music.Model.Album;
import com.trantri.tdt_music.R;
import com.trantri.tdt_music.Service.APIService;
import com.trantri.tdt_music.Service.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachAllAlbumActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Toolbar toolbar;
    DanhSachAllAlbumAdapter mDanhSachAllAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_all_album);
        initView();
        GetData();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycleAllAlbum);
        toolbar = findViewById(R.id.toolbarAllAlbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tất Cả AlBum Bài Hát");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> mCall = dataService.getAllAlbum();
        mCall.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albumList = response.body();
                mDanhSachAllAlbumAdapter = new DanhSachAllAlbumAdapter(DanhSachAllAlbumActivity.this, albumList);
                mRecyclerView.setLayoutManager(new GridLayoutManager(DanhSachAllAlbumActivity.this, 2));
                mRecyclerView.setAdapter(mDanhSachAllAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
