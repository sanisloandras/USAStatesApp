package com.sanislo.soft.usastatesapp.domain;

import com.sanislo.soft.usastatesapp.data.response.StatesResponse;
import com.sanislo.soft.usastatesapp.domain.model.StatesResponseModel;

import io.reactivex.Single;

public interface LoadAllUSAStatesUseCase {
    Single<StatesResponseModel> execute();
}
