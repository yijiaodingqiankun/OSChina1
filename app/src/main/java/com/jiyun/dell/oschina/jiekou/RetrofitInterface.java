package com.jiyun.dell.oschina.jiekou;

import com.jiyun.dell.oschina.bean.ZiXun;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


/**
 * Created by DELL zhanghuirong on 2017/7/19.
 */

public interface RetrofitInterface {
    @GET("action/api/news_list")
    Call<ZiXun> getData(@QueryMap Map<String, String> map);
}
