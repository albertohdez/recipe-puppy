package com.alberto.recipepuppy.service;


import com.alberto.recipepuppy.common.model.response.SearchResponse;

import rx.Observable;

public class AppServiceImpl implements AppService {

    private final ApiClient apiClient;

    public AppServiceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Observable<SearchResponse> search(String query) {
        return apiClient.getService().search(query);
    }
}
