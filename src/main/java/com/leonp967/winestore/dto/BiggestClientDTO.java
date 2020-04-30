package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BiggestClientDTO {

    @JsonProperty("cpfCliente")
    private String clientCpf;

    @JsonProperty("totalCompra")
    private Double purchaseTotal;

    public static Builder builder() {
        return new Builder();
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public Double getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Double purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public static final class Builder {
        private String clientCpf;
        private Double purchaseTotal;

        private Builder() {
        }

        public static Builder aBiggestClientDTO() {
            return new Builder();
        }

        public Builder clientCpf(String clientCpf) {
            this.clientCpf = clientCpf;
            return this;
        }

        public Builder purchaseTotal(Double purchaseTotal) {
            this.purchaseTotal = purchaseTotal;
            return this;
        }

        public BiggestClientDTO build() {
            BiggestClientDTO biggestClientDTO = new BiggestClientDTO();
            biggestClientDTO.setClientCpf(clientCpf);
            biggestClientDTO.setPurchaseTotal(purchaseTotal);
            return biggestClientDTO;
        }
    }
}
