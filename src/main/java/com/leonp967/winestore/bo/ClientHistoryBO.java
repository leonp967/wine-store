package com.leonp967.winestore.bo;

import java.time.LocalDate;
import java.util.List;

public class ClientHistoryBO {

    private String code;
    private LocalDate date;
    private List<SaleItemBO> items;
    private Double total;
    private String clientCpf;
    private Long clientId;

    public static Builder builder() {
        return new Builder();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<SaleItemBO> getItems() {
        return items;
    }

    public void setItems(List<SaleItemBO> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public static final class Builder {
        private String code;
        private LocalDate date;
        private List<SaleItemBO> items;
        private Double total;
        private String clientCpf;
        private Long clientId;

        private Builder() {
        }

        public static Builder aClientHistoryBO() {
            return new Builder();
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder items(List<SaleItemBO> items) {
            this.items = items;
            return this;
        }

        public Builder total(Double total) {
            this.total = total;
            return this;
        }

        public Builder clientCpf(String clientCpf) {
            this.clientCpf = clientCpf;
            return this;
        }

        public Builder clientId(Long clientId) {
            this.clientId = clientId;
            return this;
        }

        public ClientHistoryBO build() {
            ClientHistoryBO clientHistoryBO = new ClientHistoryBO();
            clientHistoryBO.setCode(code);
            clientHistoryBO.setDate(date);
            clientHistoryBO.setItems(items);
            clientHistoryBO.setTotal(total);
            clientHistoryBO.setClientCpf(clientCpf);
            clientHistoryBO.setClientId(clientId);
            return clientHistoryBO;
        }
    }
}
