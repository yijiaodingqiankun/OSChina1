package com.jiyun.dell.oschina.net;

/**
 * Created by DELL zhanghuirong on 2017/7/20.
 */

public class Urls {
    public static final String BAST_NAME = "http://www.oschina.net/";
    public static final String ZIXUN_NAME = BAST_NAME + "action/api/news_list?catalog=1&pageIndex=1&pageSize=20";
    //热点
    public static final String BASE_REDIAN=BAST_NAME+"action/api/news_list?catalog=4&pageIndex=1&pageSize=10&show=week";
    //新闻详情
    public static final String BASE_NEWS=BAST_NAME+"action/api/news_detail?id=0";
    //博客详情
    public static final String BASE_BOKEXIANGQING=BAST_NAME+"action/api/blog_detail?id=0";
    //博客
    public static final String BASE_BOKE=BAST_NAME+"action/api/blog_list?type=latest&pageIndex=1&pageSize=20";




    //技术问答


    public static final String BASE_JISHU=BAST_NAME+"action/api/post_list?catalog=1&pageIndex=1&pageSize=20";

}
