package com.sanislo.soft.usastatesapp.domain.mapper;

import com.sanislo.soft.usastatesapp.data.response.ResultItem;
import com.sanislo.soft.usastatesapp.domain.Mapper;
import com.sanislo.soft.usastatesapp.domain.model.StateModel;

public class StateItemToStateModel extends Mapper<ResultItem, StateModel> {

    @Override
    public StateModel map(ResultItem input) {
        return new StateModel(input.getArea(),
                input.getCountry(),
                input.getCapital(),
                input.getName(),
                input.getId(),
                input.getAbbr(),
                input.getLargestCity());
    }
}
