package com.jiyun.dell.oschina.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.bean.Message;
import com.jiyun.dell.oschina.wode.SysActivity;

import java.util.ArrayList;

/**
 * Created by DELL zhanghuirong on 2017/7/17.
 */

public class MyWodeAdapter extends RecyclerView.Adapter<MyWodeAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Message> arrayList;

    public MyWodeAdapter(Context context, ArrayList<Message> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wodebuju, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.img1.setImageResource(arrayList.get(position).getImg());
        holder.textname.setText(arrayList.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img1;
        private final TextView textname;
        private final View itemView1;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView1 = itemView;
            img1 = (ImageView) itemView.findViewById(R.id.imgview);
            textname = (TextView) itemView.findViewById(R.id.textname);
        }
    }
}
