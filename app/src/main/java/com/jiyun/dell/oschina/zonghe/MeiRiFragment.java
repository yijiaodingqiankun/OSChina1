package com.jiyun.dell.oschina.zonghe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.bean.BoKe;
import com.jiyun.dell.oschina.http.OkHttpUtil;
import com.jiyun.dell.oschina.net.Urls;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeiRiFragment extends Fragment {


    private RecyclerView recyclerview;
    List<BoKe.BlogBean> list=new ArrayList<>();
    private MyMeiRiAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mei_ri, container, false);

        initView(view);
        initData();

        return view;
    }

    private void initAdapter() {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(manager);

        adapter = new MyMeiRiAdapter(getActivity(),list);
        recyclerview.setAdapter(adapter);
    }

    private void initData() {

        OkHttpUtil.getInstance().get(Urls.BASE_BOKE, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("onResponse----------",string );
                XStream xStream=new XStream();
                xStream.alias("oschina",BoKe.class);
                xStream.alias("blog",BoKe.BlogBean.class);

                BoKe boKe = (BoKe) xStream.fromXML(string);
                List<BoKe.BlogBean> blogs = boKe.getBlogs();
                list.addAll(blogs);
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
        recyclerview = (RecyclerView) view.findViewById(R.id.mrecyclerview);
        initAdapter();
    }
}
