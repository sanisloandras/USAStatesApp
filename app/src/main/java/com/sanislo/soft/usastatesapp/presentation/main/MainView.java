package com.sanislo.soft.usastatesapp.presentation.main;

import com.sanislo.soft.usastatesapp.base.BaseView;
import com.sanislo.soft.usastatesapp.domain.model.StatesResponseModel;

public interface MainView extends BaseView {
    void showProgress(boolean isShowProgress);
    void onStatesLoaded(StatesResponseModel statesResponseModel);
    void onError(Throwable error);
}
