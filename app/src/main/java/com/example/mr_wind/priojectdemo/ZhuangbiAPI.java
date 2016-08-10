package com.example.mr_wind.priojectdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mr_wind on 2016/7/28.
 */
public interface ZhuangbiAPI {
    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);
}
