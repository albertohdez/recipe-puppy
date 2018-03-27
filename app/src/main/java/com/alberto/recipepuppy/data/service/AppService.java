package com.alberto.recipepuppy.data.service;


import com.alberto.recipepuppy.common.model.response.SearchResponse;

import rx.Observable;

public interface AppService {
    Observable<SearchResponse> search(String query);
}
