package com.jiyun.dell.oschina.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.jiyun.dell.oschina.R;

public class YaoyiYaoActivity extends AppCompatActivity {

    private ImageView img;
    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaoyi_yao);
        initView();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);

        sm = (SensorManager)getSystemService(this.SENSOR_SERVICE);
        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    private SensorEventListener listener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
//              关线传感器
            /* float value = event.values[0];//获取光线强度
             Sensor sensor = event.sensor;
             textView.setText(value+"");*/

//          加速度传感器
            float xValue = Math.abs(event.values[0]);
            float yValue = Math.abs(event.values[1]);
            float zValue = Math.abs(event.values[2]);

            if (xValue>15 || yValue>15 || zValue>15){
                Toast.makeText(YaoyiYaoActivity.this, "摇一摇", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

            Log.i("TAG", "onAccuracyChanged: " + accuracy);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sm!=null){
            sm.unregisterListener(listener);
//            sm.unregisterListener(listener);
        }
    }
}

