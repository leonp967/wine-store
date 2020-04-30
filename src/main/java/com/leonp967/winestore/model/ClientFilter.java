package com.leonp967.winestore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientFilter {

    @JsonProperty("filterType")
    private FilterTypeEnum filterType;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("shouldLimit")
    private Boolean shouldLimit;

    public FilterTypeEnum getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterTypeEnum filterType) {
        this.filterType = filterType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Boolean getShouldLimit() {
        return shouldLimit;
    }

    public void setShouldLimit(Boolean shouldLimit) {
        this.shouldLimit = shouldLimit;
    }
}
