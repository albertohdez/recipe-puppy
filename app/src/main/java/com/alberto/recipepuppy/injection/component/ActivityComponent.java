package com.alberto.recipepuppy.injection.component;

import android.app.Activity;

import com.alberto.recipepuppy.injection.annotation.PerActivity;
import com.alberto.recipepuppy.injection.module.ActivityModule;
import com.alberto.recipepuppy.ui.home.HomeActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Activities
    Activity activity();

    void inject(HomeActivity homeActivity);

}
