package com.alberto.recipepuppy;


import android.app.Application;

import com.alberto.recipepuppy.injection.component.ApplicationComponent;
import com.alberto.recipepuppy.injection.component.DaggerApplicationComponent;
import com.alberto.recipepuppy.injection.module.ApplicationModule;

public class RPApplication extends Application {
    private ApplicationComponent applicationComponent = createAppComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        getApplicationComponent().inject(this);
    }

    protected ApplicationComponent createAppComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
