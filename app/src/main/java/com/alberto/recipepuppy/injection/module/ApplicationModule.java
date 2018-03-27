package com.alberto.recipepuppy.injection.module;

import android.content.Context;

import com.alberto.recipepuppy.RPApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final RPApplication rpApplication;

    public ApplicationModule(RPApplication application) {
        rpApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return rpApplication;
    }

}
