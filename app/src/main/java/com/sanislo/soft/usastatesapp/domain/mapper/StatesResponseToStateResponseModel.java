package com.sanislo.soft.usastatesapp.domain.mapper;

import com.sanislo.soft.usastatesapp.data.response.StatesResponse;
import com.sanislo.soft.usastatesapp.domain.LoadAllUSAStatesUseCaseI;
import com.sanislo.soft.usastatesapp.domain.Mapper;
import com.sanislo.soft.usastatesapp.domain.model.StatesResponseModel;

public class StatesResponseToStateResponseModel extends Mapper<StatesResponse, StatesResponseModel> {
    private StateItemToStateModel mStateItemToStateModel;

    public StatesResponseToStateResponseModel(StateItemToStateModel stateItemToStateModel) {
        mStateItemToStateModel = stateItemToStateModel;
    }

    @Override
    public StatesResponseModel map(StatesResponse input) {
        return new StatesResponseModel(
                input.getRestResponse().getMessages(),
                mStateItemToStateModel.map(input.getRestResponse().getResult())
        );
    }
}