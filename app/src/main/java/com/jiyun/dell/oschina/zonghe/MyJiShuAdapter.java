package com.jiyun.dell.oschina.zonghe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.bean.BoKe;

import java.util.List;

/**
 * Created by DELL zhanghuirong on 2017/7/20.
 */

class MyJiShuAdapter extends RecyclerView.Adapter<MyJiShuAdapter.ViewHolder> {
    private Context context;
    private List<BoKe.BlogBean> list;
    private SpannableString spannableString;
    private ImageSpan imageSpan;


    public MyJiShuAdapter(Context context, List<BoKe.BlogBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemtuijian_recyc, parent, false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());

//        int[] images={R.drawable.ic_label_today,R.drawable.ic_label_recommend,R.drawable.ic_label_reprint};

//创建drawable对象
//        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_label_originate);
//        Drawable drawable1 = context.getResources().getDrawable(R.drawable.ic_label_recommend);
//        Drawable drawable2 = context.getResources().getDrawable(R.drawable.ic_label_reprint);
//        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//        drawable1.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//        drawable2.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());

//        spannableString = new SpannableString("          "+holder.title.getText().toString());
//baseline 沿着基线对齐
//        imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);

//参数1：表示把一个图片的span对象放入Spannable对象里面，参数2，参数3表示我们放入的对象
//适用在那个范围内，
//baseline 沿着基线对齐


//参数1：表示把一个图片的span对象放入Spannable对象里面，参数2，参数3表示我们放入的对象
//适用在那个范围内，
//        ImageSpan imageSpan2 = new ImageSpan(drawable1, ImageSpan.ALIGN_BASELINE);
//        ImageSpan imageSpan3 = new ImageSpan(drawable2, ImageSpan.ALIGN_BASELINE);
//        spannableString.setSpan(imageSpan,0,3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        spannableString.setSpan(imageSpan2,5,6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        spannableString.setSpan(imageSpan3,8,9, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

//        holder.title.setText(spannableString);




        holder.con.setText(list.get(position).getBody());
        holder.name.setText(list.get(position).getAuthorname());
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
