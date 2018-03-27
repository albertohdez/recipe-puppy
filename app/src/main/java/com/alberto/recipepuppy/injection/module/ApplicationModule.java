package com.alberto.recipepuppy.injection.module;

import android.content.Context;

import com.alberto.recipepuppy.RPApplication;
import com.alberto.recipepuppy.service.ApiClient;
import com.alberto.recipepuppy.service.AppService;
import com.alberto.recipepuppy.service.AppServiceImpl;

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

    @Provides
    @Singleton
    ApiClient provideApiClient() {
        return new ApiClient();
    }

    @Provides
    @Singleton
    AppService provideAppService(ApiClient apiClient) {
        return new AppServiceImpl(apiClient);
    }
}
