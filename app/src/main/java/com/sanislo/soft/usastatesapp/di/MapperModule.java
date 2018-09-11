package com.sanislo.soft.usastatesapp.di;

import com.sanislo.soft.usastatesapp.domain.mapper.StateItemToStateModel;
import com.sanislo.soft.usastatesapp.domain.mapper.StatesResponseToStateResponseModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {

    @Provides
    StatesResponseToStateResponseModel provideStatesResponseToStateResponseModel(StateItemToStateModel stateItemToStateModel) {
        return new StatesResponseToStateResponseModel(stateItemToStateModel);
    }

    @Provides
    StateItemToStateModel provideStateItemToStateModel() {
        return new StateItemToStateModel();
    }
}
