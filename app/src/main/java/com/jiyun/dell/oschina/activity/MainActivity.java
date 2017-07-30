package com.jiyun.dell.oschina.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.base.BaseActivity;
import com.jiyun.dell.oschina.base.FragmentBuilder;
import com.jiyun.dell.oschina.fragment.FindFragment;
import com.jiyun.dell.oschina.fragment.MoveFragment;
import com.jiyun.dell.oschina.fragment.MultipleFragment;
import com.jiyun.dell.oschina.fragment.MyFragment;


/**
 * 可以在这里测试一些代码
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    private FrameLayout framelayout;
    private RadioButton zonghe;
    private RadioButton dongtan;
    private ImageView jiahao;
    private RadioButton faxian;
    private RadioButton wode;
    private RadioGroup radio;



    @Override
    protected void initData() {

    }

    @Override
    protected void initId() {

        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        zonghe = (RadioButton) findViewById(R.id.zonghe);
        dongtan = (RadioButton) findViewById(R.id.dongtan);
        jiahao = (ImageView) findViewById(R.id.jiahao);
        faxian = (RadioButton) findViewById(R.id.faxian);
        wode = (RadioButton) findViewById(R.id.wode);
        radio = (RadioGroup) findViewById(R.id.radio);
        radio.setOnCheckedChangeListener(this);
        jiahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

        FragmentBuilder.getFragmentBuilder().containerId(R.id.framelayout).satrt(MultipleFragment.class).build();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }



    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        /*FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();*/
        switch (checkedId) {
            case R.id.zonghe:

                FragmentBuilder.getFragmentBuilder().containerId(R.id.framelayout).satrt(MultipleFragment.class).build();
                break;
            case R.id.dongtan:

                FragmentBuilder.getFragmentBuilder().containerId(R.id.framelayout).satrt(MoveFragment.class).build();

                break;
            case R.id.faxian:
                FragmentBuilder.getFragmentBuilder().containerId(R.id.framelayout).satrt(FindFragment.class).build();

                break;
            case R.id.wode:
                FragmentBuilder.getFragmentBuilder().containerId(R.id.framelayout).satrt(MyFragment.class).build();

                break;

        }
    }
}
