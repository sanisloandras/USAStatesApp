package com.sanislo.soft.usastatesapp.data;

import com.sanislo.soft.usastatesapp.data.response.StatesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface AppApi {
    @GET("state/get/USA/all")
    Single<StatesResponse> getAllUSAStates();
}
