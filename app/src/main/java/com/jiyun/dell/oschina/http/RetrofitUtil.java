package com.jiyun.dell.oschina.http;

import com.jiyun.dell.oschina.bean.ZiXun;
import com.jiyun.dell.oschina.jiekou.RetrofitInterface;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by DELL zhanghuirong on 2017/7/12.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;
    private Retrofit retrofit;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder().baseUrl("http://www.oschina.net/").addConverterFactory(SimpleXmlConverterFactory.create()).build();
    }

    public static RetrofitUtil getInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    public void getData(Callback<ZiXun> callback, Map<String,String> map){
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Call<ZiXun> data = retrofitInterface.getData(map);
        data.enqueue(callback);
    }
}
