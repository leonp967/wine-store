package com.leonp967.winestore.bo;

import java.util.Objects;

public class SortedClientBO {

    private ClientBO client;
    private String value;

    public static Builder builder() {
        return new Builder();
    }

    public ClientBO getClient() {
        return client;
    }

    public void setClient(ClientBO client) {
        this.client = client;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortedClientBO that = (SortedClientBO) o;
        return Objects.equals(client, that.client) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, value);
    }

    public static final class Builder {
        private ClientBO client;
        private String value;

        private Builder() {
        }

        public static Builder anOrderedClientBO() {
            return new Builder();
        }

        public Builder client(ClientBO client) {
            this.client = client;
            return this;
        }

        public Builder value(String purchasesTotal) {
            this.value = purchasesTotal;
            return this;
        }

        public SortedClientBO build() {
            SortedClientBO sortedClientBO = new SortedClientBO();
            sortedClientBO.setClient(client);
            sortedClientBO.setValue(value);
            return sortedClientBO;
        }
    }
}
