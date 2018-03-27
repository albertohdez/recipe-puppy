package com.alberto.recipepuppy.data.service;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.alberto.recipepuppy.common.constants.Constants.API_URL;


public class ApiClient {
    private Retrofit restAdapter;
    private RPService service;

    public ApiClient() {
    }

    public RPService getService() {
        if (restAdapter == null || service == null) {
            restAdapter = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            service = restAdapter.create(RPService.class);
        }

        return service;
    }

}
