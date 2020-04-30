package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FidelitySortedClientDTO implements SortedClient{

    @JsonProperty("cliente")
    private ClientDTO client;

    @JsonProperty("quantidadeCompras")
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

    public static final class Builder {
        private ClientDTO client;
        private String value;

        private Builder() {
        }

        public static Builder aFidelitySortedClientDTO() {
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

        public FidelitySortedClientDTO build() {
            FidelitySortedClientDTO fidelitySortedClientDTO = new FidelitySortedClientDTO();
            fidelitySortedClientDTO.setClient(client);
            fidelitySortedClientDTO.setValue(value);
            return fidelitySortedClientDTO;
        }
    }
}
