package com.trantri.tdt_music.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.trantri.tdt_music.Adapter.ViewPagerAdapter;
import com.trantri.tdt_music.Fragment.FragmentMV;
import com.trantri.tdt_music.Fragment.Fragment_TimKiem;
import com.trantri.tdt_music.Fragment.Fragment_TrangChu;
import com.trantri.tdt_music.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new Fragment_TrangChu(), "Trang Chủ");
        mViewPagerAdapter.addFragment(new FragmentMV(), "MV");
        mViewPagerAdapter.addFragment(new Fragment_TimKiem(), "Tìm Kiếm");

        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_video);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_search);

    }

    private void initView() {
        mTabLayout = findViewById(R.id.myTablayout);
        mViewPager = findViewById(R.id.myViewPager);
    }
}
