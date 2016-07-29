package com.example.mr_wind.priojectdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by mr_wind on 2016/7/28.
 */
public interface GitHubClient {
    @GET("data/福利/{number}/{page}")
    Observable<Contributor> contributors(@Path("number") int number, @Path("page") int page);
}
