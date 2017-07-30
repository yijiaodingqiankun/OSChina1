package com.jiyun.dell.oschina.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.base.BaseFragment;


/**
 * 动弹
 */
public class MoveFragment extends BaseFragment {

    private TextView tv;
    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void initView(View view) {
        tv = (TextView) view.findViewById(R.id.tv);
        tablayout = (TabLayout) view.findViewById(R.id.tab);
        viewPager = (ViewPager) view.findViewById(R.id.vp_viewpager);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void updateTitleBar() {
        tv.setText("动弹");

    }

    @Override
    protected int layoutId() {
        return R.layout.item_movefragment;
    }
}
