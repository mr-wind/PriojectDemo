package com.example.mr_wind.priojectdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mr_wind.priojectdemo.activity.HTextViewActivity;
import com.example.mr_wind.priojectdemo.activity.RecyclerViewActivity;

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

    @OnClick({R.id.recycle_btn, R.id.htext_btn})
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
        }
    }
}
