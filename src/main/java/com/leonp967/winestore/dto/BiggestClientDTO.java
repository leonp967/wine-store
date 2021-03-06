package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiggestClientDTO that = (BiggestClientDTO) o;
        return Objects.equals(clientCpf, that.clientCpf) &&
                Objects.equals(purchaseTotal, that.purchaseTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientCpf, purchaseTotal);
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
