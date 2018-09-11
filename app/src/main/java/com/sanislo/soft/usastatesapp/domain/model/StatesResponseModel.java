package com.sanislo.soft.usastatesapp.domain.model;

import java.util.List;

public class StatesResponseModel {
    private final List<String> messages;
    private final List<StateModel> states;

    public StatesResponseModel(List<String> messages, List<StateModel> states) {
        this.messages = messages;
        this.states = states;
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<StateModel> getStates() {
        return states;
    }

    @Override
    public String toString() {
        return "StatesResponseModel{" +
                "messages=" + messages +
                ", states=" + states +
                '}';
    }
}
