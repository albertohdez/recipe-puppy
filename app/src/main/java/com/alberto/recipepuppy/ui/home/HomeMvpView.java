package com.alberto.recipepuppy.ui.home;

import com.alberto.recipepuppy.common.model.response.SearchResponse;
import com.alberto.recipepuppy.common.view.presenter.MvpView;

public interface HomeMvpView extends MvpView {
    void searchSuccess(SearchResponse searchResponse);

    void searchError();
}
