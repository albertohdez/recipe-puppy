package com.alberto.recipepuppy.common.view.presenter;

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
