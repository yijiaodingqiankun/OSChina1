package com.jiyun.dell.oschina.zonghe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.bean.ZiXun;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/7/20.
 */

class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<ZiXun.NewsBean> list;
    private SpannableString spannableString;
    private ImageSpan imageSpan;


    public MyRecyclerAdapter(Context context, List<ZiXun.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyc, parent, false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(list.get(position).getTitle());
//创建drawable对象
        Drawable drawable=context.getResources().getDrawable(R.drawable.ic_label_today);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());

        spannableString = new SpannableString(holder.title.getText().toString());
//baseline 沿着基线对齐
        imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
//参数1：表示把一个图片的span对象放入Spannable对象里面，参数2，参数3表示我们放入的对象
//适用在那个范围内，
        spannableString.setSpan(imageSpan,0,5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        holder.title.setText(spannableString);




        holder.con.setText(list.get(position).getBody());
        holder.name.setText(list.get(position).getAuthor());
        holder.num.setText(list.get(position).getCommentCount());
        holder.time.setText(list.get(position).getPubDate());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView con;
        private final TextView name;
        private final TextView num;
        private final TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            con = (TextView) itemView.findViewById(R.id.tv_neirong);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            num = (TextView) itemView.findViewById(R.id.num);
            time = (TextView) itemView.findViewById(R.id.tv_time);

        }
    }
}
