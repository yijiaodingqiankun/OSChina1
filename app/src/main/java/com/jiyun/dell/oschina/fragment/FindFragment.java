package com.jiyun.dell.oschina.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.activity.YaoyiYaoActivity;
import com.jiyun.dell.oschina.base.BaseFragment;
import com.jiyun.dell.oschina.wode.SysActivity;


/**
 * 发现
 */
public class FindFragment extends BaseFragment {


    private TextView fx_tv;
    private TextView tv_saoyisao;
    private TextView tv_yaoyiyao;

    @Override
    protected void initView(View view) {
        fx_tv = (TextView) view.findViewById(R.id.tv);
        tv_saoyisao = (TextView) view.findViewById(R.id.tv_saoyisao);
        tv_yaoyiyao = (TextView) view.findViewById(R.id.tv_yaoyiyao);

    }

    @Override
    protected void initData() {
        tv_yaoyiyao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), YaoyiYaoActivity.class);
                startActivity(intent);
            }
        });

        tv_saoyisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SysActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    protected void updateTitleBar() {
        fx_tv.setText("发现");
    }

    @Override
    protected int layoutId() {
        return R.layout.item_fragment;
    }
}
