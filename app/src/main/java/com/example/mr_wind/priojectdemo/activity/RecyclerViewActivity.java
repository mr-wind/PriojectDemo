package com.example.mr_wind.priojectdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.example.mr_wind.priojectdemo.BaseActivity;
import com.example.mr_wind.priojectdemo.R;
import com.example.mr_wind.priojectdemo.views.recycler.SampleRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by mr_wind on 2016/8/1.
 */
public class RecyclerViewActivity extends BaseActivity {
    @BindView(R.id.add_item)
    Button mAddItem;
    @BindView(R.id.remove_item)
    Button mRemoveItem;
    final SampleRecyclerAdapter sampleRecyclerAdapter = new SampleRecyclerAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        ButterKnife.bind(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //recyclerView.setAdapter(sampleRecyclerAdapter);

        recyclerView.setAdapter(new AlphaInAnimationAdapter(sampleRecyclerAdapter));

        recyclerView.setItemAnimator(new SlideInLeftAnimator(new OvershootInterpolator(1f)));
    }

    @OnClick({R.id.add_item, R.id.remove_item})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_item:
                sampleRecyclerAdapter.addItem(sampleRecyclerAdapter.getItemCount());
                break;
            case R.id.remove_item:
                if (sampleRecyclerAdapter.getItemCount() > 0) {
                    sampleRecyclerAdapter.removeData(sampleRecyclerAdapter.getItemCount() - 1);
                }
                break;
        }
    }
}
