package com.jiyun.dell.oschina.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.adapter.MyZHAdapter;
import com.jiyun.dell.oschina.base.BaseFragment;
import com.jiyun.dell.oschina.zonghe.JiShuFragment;
import com.jiyun.dell.oschina.zonghe.KaiYuanFragment;
import com.jiyun.dell.oschina.zonghe.MeiRiFragment;
import com.jiyun.dell.oschina.zonghe.TuiJianFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 资讯
 */
public class MultipleFragment extends BaseFragment {

    private TextView biaoti;
    private TabLayout tab;
    private ViewPager viewpager;
    private List<String> listTitle;
    private List<Fragment> list;
    private ImageView imgView;


    @Override
    protected void initView(View view) {

        biaoti = (TextView) view.findViewById(R.id.tv);
        tab = (TabLayout) view.findViewById(R.id.tab);
        viewpager = (ViewPager) view.findViewById(R.id.vp_viewpager);
        imgView = (ImageView) view.findViewById(R.id.iv_imgview);

    }

    @Override
    protected void initData() {

        listTitle = new ArrayList<>();
        listTitle.add("开源资讯");
        listTitle.add("推荐博客");
        listTitle.add("技术问题");
        listTitle.add("每日一博");

        list = new ArrayList<>();
        list.add(new KaiYuanFragment());
        list.add(new TuiJianFragment());
        list.add(new JiShuFragment());
        list.add(new MeiRiFragment());

        initAdapter();
        initPoPupWindown();
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.xx);
                imgView.startAnimation(animation);
            }
        });


    }

    private void initPoPupWindown() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.item_popupwindown, null);
    }

    private void initAdapter() {

        MyZHAdapter adapter=new MyZHAdapter(getActivity().getSupportFragmentManager(),list,listTitle);

        viewpager.setAdapter(adapter);

        tab.setupWithViewPager(viewpager);
        viewpager.setCurrentItem(0);
    }

    @Override
    protected void updateTitleBar() {
        biaoti.setText("综合");
    }

    @Override
    protected int layoutId() {
        return R.layout.item_movefragment;
    }
}
