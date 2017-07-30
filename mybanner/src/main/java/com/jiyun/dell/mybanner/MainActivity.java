package com.jiyun.dell.mybanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    //Integer[] images={R.drawable.js1,R.drawable.js2,R.drawable.js3,R.drawable.js4,R.drawable.js5};

    private List<Integer> images = new ArrayList<>();
    private List<String> title = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        images.add(R.mipmap.ic_launcher);
//        images.add(R.mipmap.ic_launcher);
//        images.add(R.mipmap.ic_launcher);
//        images.add(R.mipmap.ic_launcher);
//        images.add(R.mipmap.ic_launcher);
        title.add("111");
        title.add("111");
        title.add("111");
        title.add("111");
        title.add("111");
        images.add(R.drawable.js2);
        images.add(R.drawable.js1);
        images.add(R.drawable.js3);
        images.add(R.drawable.js4);
        images.add(R.drawable.js5);

        banner = (Banner) findViewById(R.id.banner);
        //设置banner样式
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
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


    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
}
