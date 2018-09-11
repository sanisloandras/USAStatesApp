package com.sanislo.soft.usastatesapp.di;

import com.sanislo.soft.usastatesapp.presentation.main.MainPresenter;
import com.sanislo.soft.usastatesapp.data.AppApi;
import com.sanislo.soft.usastatesapp.domain.LoadAllUSAStatesUseCase;
import com.sanislo.soft.usastatesapp.domain.LoadAllUSAStatesUseCaseI;
import com.sanislo.soft.usastatesapp.domain.mapper.StatesResponseToStateResponseModel;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MapperModule.class})
public class MainModule {
    @Provides
    MainPresenter provideMainPresenter(LoadAllUSAStatesUseCase loadAllUSAStatesUseCase) {
        return new MainPresenter(loadAllUSAStatesUseCase);
    }

    @Provides
    LoadAllUSAStatesUseCase provideLoadAllUSAStatesUseCase(AppApi appApi, StatesResponseToStateResponseModel statesResponseToStateResponseModel) {
        return new LoadAllUSAStatesUseCaseI(appApi, statesResponseToStateResponseModel);
    }
}