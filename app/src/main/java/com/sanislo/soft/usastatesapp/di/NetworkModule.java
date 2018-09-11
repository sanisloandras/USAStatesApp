package com.sanislo.soft.usastatesapp.di;

import com.sanislo.soft.usastatesapp.BuildConfig;
import com.sanislo.soft.usastatesapp.data.AppApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    AppApi provideApi(OkHttpClient okHttpClient, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(AppApi.class);
    }

    @Provides
    String provideBaseURL() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }
}