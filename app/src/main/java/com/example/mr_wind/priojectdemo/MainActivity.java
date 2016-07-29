package com.example.mr_wind.priojectdemo;

import android.os.Bundle;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
/*
    @BindView(R.id.wheel_picker_1)
    WheelPicker mWheelPicker1;
    @BindView(R.id.wheel_picker_2)
    WheelPicker mWheelPicker2;*/

    List<String> mStringList = new ArrayList<>();

    List<String> mStringList2 = new ArrayList<>();

    List<String> mStringList3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

}
