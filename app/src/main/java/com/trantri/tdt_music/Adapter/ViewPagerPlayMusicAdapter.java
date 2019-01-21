package com.trantri.tdt_music.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerPlayMusicAdapter extends FragmentPagerAdapter {

    public final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    public ViewPagerPlayMusicAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return  fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    public void addFragment(Fragment fragment) {
        fragmentArrayList.add(fragment);
    }

}
