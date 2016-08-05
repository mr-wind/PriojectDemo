package com.example.mr_wind.priojectdemo.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.mr_wind.priojectdemo.BaseActivity;
import com.example.mr_wind.priojectdemo.R;
import com.github.florent37.materialtextfield.MaterialTextField;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mr_wind on 2016/8/5.
 */
public class MdEditfieldActivity extends BaseActivity {
    @BindView(R.id.mdedit_field)
    MaterialTextField mMdeditField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_textfield);
        ButterKnife.bind(this);

    }
}
