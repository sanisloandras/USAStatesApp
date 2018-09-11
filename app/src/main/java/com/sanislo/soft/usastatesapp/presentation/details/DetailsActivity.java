package com.sanislo.soft.usastatesapp.presentation.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sanislo.soft.usastatesapp.R;
import com.sanislo.soft.usastatesapp.databinding.ActivityDetailsBinding;
import com.sanislo.soft.usastatesapp.domain.model.StateModel;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_STATE_MODEL = "EXTRA_STATE_MODEL";

    private ActivityDetailsBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        StateModel stateModel = getIntent().getParcelableExtra(EXTRA_STATE_MODEL);
        StringBuilder titleStringBuilder = new StringBuilder();
        titleStringBuilder.append(stateModel.getName());
        titleStringBuilder.append(", ");
        titleStringBuilder.append(stateModel.getCountry());
        titleStringBuilder.append(", ");
        titleStringBuilder.append(stateModel.getAbbr());
        getSupportActionBar().setTitle(titleStringBuilder.toString());
        mBinding.tvCapital.setText(stateModel.getCapital());
        mBinding.tvLargestCity.setText(stateModel.getLargestCity());
        mBinding.tvId.setText(String.valueOf(stateModel.getId()));
    }
}
