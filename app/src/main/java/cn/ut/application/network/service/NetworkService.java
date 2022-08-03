package cn.ut.application.network.service;

import cn.ut.application.Entity.BaseEntity;
import cn.ut.application.Entity.InsertUser;
import cn.ut.application.Entity.Token;
import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface NetworkService {
    @POST("login")
    @FormUrlEncoded
    Flowable<BaseEntity<Token>> login(@Field("username") String username, @Field("password") String password);

    @POST("system/info")
    Flowable<BaseEntity<Token>> getUserInfo(@Header("Authorization") String Authorization);

    @POST("/system/admin/insert")
    Flowable<BaseEntity> insertUser(@Body InsertUser insertUser);
}
