package com.jiyun.dell.oschina.zonghe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.dell.oschina.GlideImageLoader;
import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.bean.ZiXun;
import com.jiyun.dell.oschina.http.OkHttpUtil;
import com.jiyun.dell.oschina.net.Urls;
import com.thoughtworks.xstream.XStream;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by DELL zhanghuirong on 2017/7/14.
 */

public class KaiYuanFragment extends Fragment {
    private Banner banner;
    private RecyclerView recyclerview;
    List<ZiXun.NewsBean> list=new ArrayList<>();
    private MyRecyclerAdapter adapter;
    private List<Integer> listimg=new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kaiyuan_fragment, null);


        initView(view);
        initData();

        return view;
    }

    private void initAdapter() {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(manager);

        adapter = new MyRecyclerAdapter(getActivity(),list);
        recyclerview.setAdapter(adapter);
    }

    private void initData() {
        listimg.add(R.drawable.xianxia);
        listimg.add(R.drawable.haha);
        listimg.add(R.drawable.hehe);
        listimg.add(R.drawable.meme);

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(listimg);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(title);
        //设置自动轮播，默认为true
        // banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();












        OkHttpUtil.getInstance().get(Urls.ZIXUN_NAME, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("onResponse----------",string );
                XStream xStream=new XStream();
                xStream.alias("oschina",ZiXun.class);
                xStream.alias("news",ZiXun.NewsBean.class);
                xStream.alias("newstype",ZiXun.NewsBean.NewstypeBean.class);
                ZiXun ziXun = (ZiXun) xStream.fromXML(string);
                List<ZiXun.NewsBean> newslist = ziXun.getNewslist();
                list.addAll(newslist);
                Log.i("onResponse++++++++",list.toString());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();


                    }
                });
            }
        });

    }


    private void initView(View view) {
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        banner = (Banner) view.findViewById(R.id.banner);

        initAdapter();
    }
}
