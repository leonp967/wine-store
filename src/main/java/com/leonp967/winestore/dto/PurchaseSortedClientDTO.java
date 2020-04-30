package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PurchaseSortedClientDTO implements SortedClient{

    @JsonProperty("cliente")
    private ClientDTO client;

    @JsonProperty("totalEmCompras")
    private String value;

    public static Builder builder() {
        return new Builder();
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
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
        PurchaseSortedClientDTO that = (PurchaseSortedClientDTO) o;
        return Objects.equals(client, that.client) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, value);
    }

    public static final class Builder {
        private ClientDTO client;
        private String value;

        private Builder() {
        }

        public static Builder anOrderedClientDTO() {
            return new Builder();
        }

        public Builder client(ClientDTO client) {
            this.client = client;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public PurchaseSortedClientDTO build() {
            PurchaseSortedClientDTO purchaseSortedClientDTO = new PurchaseSortedClientDTO();
            purchaseSortedClientDTO.setClient(client);
            purchaseSortedClientDTO.setValue(value);
            return purchaseSortedClientDTO;
        }
    }
}
