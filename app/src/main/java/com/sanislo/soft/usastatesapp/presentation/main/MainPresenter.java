package com.sanislo.soft.usastatesapp.presentation.main;

import android.annotation.SuppressLint;

import com.sanislo.soft.usastatesapp.base.BasePresenter;
import com.sanislo.soft.usastatesapp.domain.LoadAllUSAStatesUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private LoadAllUSAStatesUseCase mLoadAllUSAStatesUseCase;

    public MainPresenter(LoadAllUSAStatesUseCase loadAllUSAStatesUseCase) {
        mLoadAllUSAStatesUseCase = loadAllUSAStatesUseCase;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
        loadStates();
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadStates() {
        mLoadAllUSAStatesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    addDisposable(disposable);
                    if (isViewAttached()) getView().showProgress(true);
                })
                .doFinally(() -> {
                    if (isViewAttached()) getView().showProgress(false);
                })
                .subscribe(statesResponseModel -> {
                    if (isViewAttached()) getView().onStatesLoaded(statesResponseModel);
                }, throwable -> {
                    if (isViewAttached()) getView().onError(throwable);
                });
    }
}
