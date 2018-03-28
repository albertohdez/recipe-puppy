package com.alberto.recipepuppy.common.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alberto.recipepuppy.RPApplication;
import com.alberto.recipepuppy.injection.component.ActivityComponent;
import com.alberto.recipepuppy.injection.component.ApplicationComponent;
import com.alberto.recipepuppy.injection.component.DaggerActivityComponent;
import com.alberto.recipepuppy.injection.module.ActivityModule;


public class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        initializeInjector();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((RPApplication) getApplication()).getApplicationComponent();
    }

    private void initializeInjector() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }


}
