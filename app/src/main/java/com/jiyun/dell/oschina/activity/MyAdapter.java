package com.jiyun.dell.oschina.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/7/13.
 */

class MyAdapter extends FragmentPagerAdapter{
    private  Context context;
    private  List<Fragment> list;

    public MyAdapter(FragmentManager supportFragmentManager, List<Fragment> list) {
        super(supportFragmentManager);
        this.list=list;


    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
