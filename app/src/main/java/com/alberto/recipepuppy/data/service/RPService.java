package com.alberto.recipepuppy.data.service;


import com.alberto.recipepuppy.common.model.response.SearchResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RPService {
    @GET("/api")
    Observable<SearchResponse> search(@Query("q") String query);
}
