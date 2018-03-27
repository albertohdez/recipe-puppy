package com.alberto.recipepuppy.ui.home;


import com.alberto.recipepuppy.common.model.response.SearchResponse;
import com.alberto.recipepuppy.common.view.presenter.BasePresenter;
import com.alberto.recipepuppy.service.AppService;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePresenter extends BasePresenter<HomeMvpView> {
    private final AppService appService;

    public HomePresenter(AppService appService) {
        this.appService = appService;
    }

    public void searchQuery(String query) {
        addRxSubscription(appService.search(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().searchError();
                    }

                    @Override
                    public void onNext(SearchResponse searchResponse) {
                        getMvpView().searchSuccess(searchResponse);
                    }
                })
        );
    }
}
