package com.nneka.myapplication;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RListService {

    @GET("hours")
    Call<List<LHours>> getHours();

    @GET("skilliq")
    Call<List<LSkills>> getSkills();

    @POST("IFAIpQLSf9d1TcNu6zc6KR86SEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded()
    Call<FormD> sendFormD(@Url String fUrl,
                         @Field("entry.1877115667") String name,
                         @Field("entry.2006916086") String lastName,
                         @Field("entry.1824927963") String email,
                         @Field("entry.284483984") String link);


}
