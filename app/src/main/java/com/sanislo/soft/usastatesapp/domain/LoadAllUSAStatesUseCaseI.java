package com.sanislo.soft.usastatesapp.domain;

import com.sanislo.soft.usastatesapp.data.AppApi;
import com.sanislo.soft.usastatesapp.domain.mapper.StatesResponseToStateResponseModel;
import com.sanislo.soft.usastatesapp.domain.model.StatesResponseModel;

import io.reactivex.Single;

public class LoadAllUSAStatesUseCaseI implements LoadAllUSAStatesUseCase {
    private AppApi mAppApi;
    private StatesResponseToStateResponseModel mStatesResponseToStateResponseModel;

    public LoadAllUSAStatesUseCaseI(AppApi appApi, StatesResponseToStateResponseModel statesResponseToStateResponseModel) {
        mAppApi = appApi;
        mStatesResponseToStateResponseModel = statesResponseToStateResponseModel;
    }

    @Override
    public Single<StatesResponseModel> execute() {
        return mAppApi.getAllUSAStates()
                .map(statesResponse -> mStatesResponseToStateResponseModel.map(statesResponse));
    }

}
