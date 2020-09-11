package com.nneka.myapplication;

import retrofit2.Retrofit;

public class ServiceBuilder {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/api/" ;
    private static Retrofit.Builder sBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit sRetrofit = sBuilder.build();

    public static <S> S BuildService (Class<S> serviceType){
        return sRetrofit.create(serviceType);
    }

}
