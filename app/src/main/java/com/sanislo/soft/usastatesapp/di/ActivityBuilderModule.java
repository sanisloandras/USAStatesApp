package com.sanislo.soft.usastatesapp.di;

import com.sanislo.soft.usastatesapp.presentation.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity contributeMainActivity();
}