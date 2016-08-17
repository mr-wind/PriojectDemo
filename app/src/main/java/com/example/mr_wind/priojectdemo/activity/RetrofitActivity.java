package com.example.mr_wind.priojectdemo.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mr_wind.priojectdemo.BaseActivity;
import com.example.mr_wind.priojectdemo.R;
import com.example.mr_wind.priojectdemo.ZhuangbiAPI;
import com.example.mr_wind.priojectdemo.ZhuangbiImage;
import com.github.florent37.materialtextfield.MaterialTextField;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mr_wind on 2016/8/9.
 */
public class RetrofitActivity extends BaseActivity {
    @BindView(R.id.image_view)
    ImageView mImageView;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    @BindView(R.id.edit_query)
    EditText mEditQuery;
    @BindView(R.id.mdedit_field)
    MaterialTextField mMdeditField;
    @BindView(R.id.btn_search)
    Button mBtnSearch;

    Observer<List<ZhuangbiImage>> observer = new Observer<List<ZhuangbiImage>>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(List<ZhuangbiImage> images) {
            Log.d("tag", images.get(0).image_url);
            String url = images.get(0).image_url;
            Glide.with(RetrofitActivity.this).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mImageView);
        }
    };

    ZhuangbiAPI service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        mEditQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("change", "before:" + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("change", "chang:" + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("change", "after:" + editable);
                getAPI().search(editable.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
            }
        });
    }

    public ZhuangbiAPI getAPI() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://zhuangbi.info/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            service = retrofit.create(ZhuangbiAPI.class);
        }
        return service;
    }

    @OnClick(R.id.btn_search)
    public void onClick() {
        getAPI().search(mEditQuery.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        Log.d("tag", "" + mMdeditField.getEditText().toString());
    }

}
