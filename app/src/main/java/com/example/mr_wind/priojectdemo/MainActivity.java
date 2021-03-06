package com.example.mr_wind.priojectdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.mr_wind.priojectdemo.activity.HTextViewActivity;
import com.example.mr_wind.priojectdemo.activity.MdEditfieldActivity;
import com.example.mr_wind.priojectdemo.activity.RecyclerViewActivity;
import com.example.mr_wind.priojectdemo.activity.RetrofitActivity;
import com.example.mr_wind.priojectdemo.service.FloatService;
import com.example.mr_wind.priojectdemo.utils.APKUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {
/*
    @BindView(R.id.wheel_picker_1)
    WheelPicker mWheelPicker1;
    @BindView(R.id.wheel_picker_2)
    WheelPicker mWheelPicker2;*/

    List<String> mStringList = new ArrayList<>();

    List<String> mStringList2 = new ArrayList<>();

    List<String> mStringList3 = new ArrayList<>();
    @BindView(R.id.recycle_btn)
    Button mRecycleBtn;
    @BindView(R.id.htext_btn)
    Button mHtextBtn;
    @BindView(R.id.mdedit_btn)
    Button mMdeditBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        for (int i = 0; i < 20; i++) {
            mStringList.add("A" + i);
            mStringList2.add("B" + i);
            mStringList3.add("C" + i);

        }
        ;
       /* mWheelPicker1.setData(mStringList);
        mWheelPicker1.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_SHORT).show();
                if (data.equals("A10")) {
                    mWheelPicker2.setData(mStringList3);
                }
            }
        });
        mWheelPicker2.setData(mStringList2);*/


    }

    @OnClick({R.id.recycle_btn, R.id.htext_btn, R.id.mdedit_btn, R.id.retrofit_btn, R.id.float_btn, R.id.open_other_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recycle_btn:
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.htext_btn:
                Intent intent1 = new Intent(MainActivity.this, HTextViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.mdedit_btn:
                Intent intent2 = new Intent(MainActivity.this, MdEditfieldActivity.class);
                startActivity(intent2);
                break;
            case R.id.retrofit_btn:
                Intent intent3 = new Intent(MainActivity.this, RetrofitActivity.class);
                startActivity(intent3);
                break;
            case R.id.float_btn:
                Intent intent4 = new Intent(MainActivity.this, FloatService.class);
                startService(intent4);
                //finish();
                break;
            case R.id.open_other_btn:
                APKUtil.startOtherApp(getApplicationContext(), "com.dsplayer");
                break;
        }
    }
}
