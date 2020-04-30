package com.leonp967.winestore.bo;

public class BiggestClientBO {

    private String clientCpf;
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
        private Double totalPurchase;

        private Builder() {
        }

        public static Builder aBiggestClientBO() {
            return new Builder();
        }

        public Builder clientCpf(String clientCpf) {
            this.clientCpf = clientCpf;
            return this;
        }

        public Builder totalPurchase(Double totalPurchase) {
            this.totalPurchase = totalPurchase;
            return this;
        }

        public BiggestClientBO build() {
            BiggestClientBO biggestClientBO = new BiggestClientBO();
            biggestClientBO.setClientCpf(clientCpf);
            biggestClientBO.setPurchaseTotal(totalPurchase);
            return biggestClientBO;
        }
    }
}
