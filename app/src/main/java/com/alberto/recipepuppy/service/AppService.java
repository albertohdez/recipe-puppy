package com.alberto.recipepuppy.service;


import com.alberto.recipepuppy.common.model.response.SearchResponse;

import rx.Observable;

public interface AppService {
    Observable<SearchResponse> search(String query);
}
