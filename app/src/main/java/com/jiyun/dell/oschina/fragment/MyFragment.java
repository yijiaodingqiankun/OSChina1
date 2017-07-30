package com.jiyun.dell.oschina.fragment;


import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jiyun.dell.oschina.R;
import com.jiyun.dell.oschina.adapter.MyWodeAdapter;
import com.jiyun.dell.oschina.base.BaseFragment;
import com.jiyun.dell.oschina.bean.Message;
import com.jiyun.dell.oschina.bean.MyDecoration;

import java.util.ArrayList;
import java.util.Hashtable;


/**
 * 我的
 */
public class MyFragment extends BaseFragment {
    private int[] img={R.mipmap.ic_my_message,R.mipmap.ic_my_blog,R.mipmap.ic_my_question,R.mipmap.ic_my_event,R.mipmap.ic_my_team};
    private String[] text={"我的消息","我的博客","我的问答","我的活动","我的团队"};
    private RecyclerView recyclerView;
    private ImageButton img_two_ma;
    private LinearLayout viewById;


    private static final int QR_WIDTH = 800;
    private static final int QR_HEIGHT = 800;
    private ArrayList<String> card = new ArrayList<>();
    ImageView ewmimg;
    TextView ewmname;
    private  View view;
    private AlertDialog qrCodedialog;//V7包
    private MyWodeAdapter adapter;

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyc);
        img_two_ma = (ImageButton) view.findViewById(R.id.img_two_ma);
        viewById  =(LinearLayout) view.findViewById(R.id.lin);
       img_two_ma.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            showQrCode();
           }
       });

    }

    @Override
    protected void initData() {
        ArrayList<Message> arrayList=new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            Message message=new Message(img[i],text[i]);
            arrayList.add(message);
        }

        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new MyWodeAdapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyDecoration(getContext(),MyDecoration.VERTICAL_LIST));



    }

    public void showQrCode() {
        qrCodedialog = new AlertDialog.Builder(getActivity()).create();
        View qrview = LayoutInflater.from(getActivity()).inflate(R.layout.activity_ewma, null);

        ewmimg = (ImageView) qrview.findViewById(R.id.ewmimg);
//        ewmname = (TextView) qrview.findViewById(R.id.ewmname);
        card.clear();
        card.add("张惠荣");
        card.add("13241168880");
        card.add("老板培训公司");
        card.add("老板");
        card.add("老板");
        card.add("1524832680@qq.com");
        card.add("http://xiaoyuanwang.com.cn/");
        card.add("俊5 #621");
        qrcode(view);
//        ewmname.setText(card.toString());


        qrCodedialog.setView(qrview, 0, 0, 0, 0);
        qrCodedialog.show();
        WindowManager.LayoutParams params = qrCodedialog.getWindow().getAttributes();
        params.width = 800;
        params.height = 800;
        qrCodedialog.getWindow().setAttributes(params);
    }
    public void qrcode(View view){
        ewmimg.setImageBitmap(createQrcode(enQrCodeOneContact(card)));
    }
    public Bitmap createQrcode(String qrcode) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            if (qrcode == null || "".equals(qrcode) || qrcode.length() < 1) {
                Toast.makeText(getActivity(),"数据为空",Toast.LENGTH_SHORT).show();
                return null;
            }
            // TODO 编码格式
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            // TODO 二维码宽高、颜色
            BitMatrix bitMatrix = writer.encode(qrcode,
                    BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff0000ff;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }

                }
            }
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            return  bitmap;
        } catch (Exception e) {
            Log.e("All_Exception", e.toString());
            Toast.makeText(getActivity(),"数据太大，请重新选择",Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    public String enQrCodeOneContact(ArrayList<String> nameCard){

        StringBuilder ss = new StringBuilder();
        ss.append(String.format("BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "N:%s",nameCard.get(0)))
                .append(String.format("\nTEL;iPhone;VOICE:%s",nameCard.get(1)))
                .append("\nORG:" + nameCard.get(2))
                .append("\nTITLE:"+nameCard.get(3))
                .append("\nROLE:"+nameCard.get(4))
                .append("\nEMAIL:"+nameCard.get(5))
                .append("\nADR:"+nameCard.get(6))
                .append("\nHTTP:"+nameCard.get(7))
                .append("\nEND:VCARD");
        return ss.toString();

    }


    @Override
    protected void updateTitleBar() {

    }

    @Override
    protected int layoutId() {
        return R.layout.item_myfragment;
    }

}
