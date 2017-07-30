package com.jiyun.qcloud.pop;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {


    private boolean isExit;


    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void findViews() {
        TextView textView= (TextView) findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void release() {

    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {//获取的是back'键
            //event.getAction() == KeyEvent.ACTION_DOWN表示该按键被按下
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                exit();
                return true;
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 通过handler发送消息，如果在两秒以内点击了退出按钮，该代码就不会走，如果在两秒以后点击了退出按钮，该方法会走，并重置isExit
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            //退出所有的activity
            ActivityMgr.getActivityManager().popAllActivity();
        }
    }


    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
}
