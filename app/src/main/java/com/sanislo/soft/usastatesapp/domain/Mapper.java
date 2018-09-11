package com.sanislo.soft.usastatesapp.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<FROM, TO> {
    public abstract TO map(FROM input);

    public List<TO> map(List<FROM> fromList) {
        List<TO> toList = null;
        if (fromList != null) {
            toList = new ArrayList<>();
            TO to;
            for (FROM from : fromList) {
                to = map(from);
                toList.add(to);
            }
        }
        return toList;
    }
}