package com.hoyn.net;

import com.hoyn.data.RequestResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * <p>Get请求</p>
 * @GET("/ajax/demo_get2.asp") Observable<String> getW3c(@Query("fname") String fname, @Query("lname") String lname);
 * <p>Post请求</p>
 * @Multipart
 * @POST("/") Observable<String> getBanner(@Part("action") String action);
 * 或
 * @FormUrlEncoded
 * @POST("/openapi/api") Observable<String> getResult(@FieldMap Map<String,String> params);
 * <p>Post上传文件</p>
 * @POST("/analyze") Observable<String> upLoadImage(@Body RequestBody file, @Query("api_key") String api_key, @Query("api_secret") String api_secret);
 * <p>用okhttp的part上传(最有效)</p>
 * @Multipart
 * @POST("/analyze") Observable<String> upLoadImage(@Part MultipartBody.Part file, @Part MultipartBody.Part api_key, @Part MultipartBody.Part api_secret );
 * <p>20秒缓存[只支持GET]</p>
 * @Headers("cache:20")
 */

public interface IRequest {

    /**
     * 获取神奇宝贝结果
     * @param lat 纬度
     * @param longs 经度
     * @return
     */
    @GET("/map/data/{lat}/{long}")
    Observable<RequestResult> getPokemon(@Path("lat") String lat,@Path("long") String longs);




}
