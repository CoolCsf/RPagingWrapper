package com.csf.sample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {


    //https://newsapi.org/v2/everything?q=movies&apiKey=079dac74a5f94ebdb990ecf61c8854b7&pageSize=20&page=2

//    @GET("/v2/everything")
//    Call<Feed> fetchFeed(@Query("q") String q,
//                         @Query("apiKey") String apiKey,
//                         @Query("page") long page,
//                         @Query("pageSize") int pageSize);
    @GET("http://api.dbaoy.com:8082/Service.svc/Web/GetProducts/{code}/{pwd}/{cateId}/{companyId}/{pageNumber}")
    Call<GetProductsResponse> getProducts(@Path("code") String userName, @Path("pwd") String pwd, @Path("cateId") String cateId,
                                          @Path("companyId") String companyId, @Path("pageNumber") String pageNumber);
}
