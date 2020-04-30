package com.leonp967.winestore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FilterTypeEnum {

    @JsonProperty("purchases")
    PURCHASES("purchases"),
    @JsonProperty("fidelity")
    FIDELITY("fidelity");

    String description;

    FilterTypeEnum(String description) {
        this.description = description;
    }
}
