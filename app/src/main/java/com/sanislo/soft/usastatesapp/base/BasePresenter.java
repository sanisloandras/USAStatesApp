package com.sanislo.soft.usastatesapp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends BaseView> {
    private T view;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public T getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public void addDisposable(Disposable d) {
        mCompositeDisposable.add(d);
    }

    public void clear() {
        mCompositeDisposable.clear();
        detachView();
    }
}
