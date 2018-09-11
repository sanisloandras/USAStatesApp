package com.sanislo.soft.usastatesapp.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        NetworkModule.class,
        MainModule.class})
public class AppModule {
    @Provides
    Context provideApplicationContext(Application application) {
        return application.getApplicationContext();
    }
}