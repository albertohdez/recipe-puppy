package com.alberto.recipepuppy.injection.module;

import android.app.Activity;

import com.alberto.recipepuppy.injection.annotation.PerActivity;
import com.alberto.recipepuppy.ui.home.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }


    @Provides
    @PerActivity
    HomePresenter provideHomePresenter() {
        return new HomePresenter();
    }

}
