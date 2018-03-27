package com.alberto.recipepuppy.injection.component;

import com.alberto.recipepuppy.RPApplication;
import com.alberto.recipepuppy.common.view.activity.BaseActivity;
import com.alberto.recipepuppy.data.service.AppService;
import com.alberto.recipepuppy.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    void inject(RPApplication application);

    AppService appService();
}
