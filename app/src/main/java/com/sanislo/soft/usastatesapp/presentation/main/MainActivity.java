package com.sanislo.soft.usastatesapp.presentation.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sanislo.soft.usastatesapp.R;
import com.sanislo.soft.usastatesapp.databinding.ActivityMainBinding;
import com.sanislo.soft.usastatesapp.domain.model.StateModel;
import com.sanislo.soft.usastatesapp.domain.model.StatesResponseModel;
import com.sanislo.soft.usastatesapp.presentation.details.DetailsActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject MainPresenter mMainPresenter;

    private ActivityMainBinding mBinding;
    private StateAdapter mStateAdapter = new StateAdapter(this::navigateToDetails);

    private void navigateToDetails(StateModel stateModel) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_STATE_MODEL, stateModel);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainPresenter.attachView(this);
        setupStatesList();
    }

    private void setupStatesList() {
        mBinding.rvStates.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.rvStates.setAdapter(mStateAdapter);
    }

    @Override
    public void showProgress(boolean isShowProgress) {
        mBinding.pb.setVisibility(isShowProgress ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onStatesLoaded(StatesResponseModel statesResponseModel) {
        updateStates(statesResponseModel);
    }

    private void updateStates(StatesResponseModel statesResponseModel) {
        mStateAdapter.submitList(statesResponseModel.getStates());
    }

    @Override
    public void onError(Throwable error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.clear();
    }
}
