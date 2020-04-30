package com.leonp967.winestore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client_history")
public class ClientHistoryEntity implements Serializable {

    @Id
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "created_date")
    private LocalDate date;

    @OneToMany(mappedBy = "clientHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleItemEntity> items;

    @Column(name = "total")
    private Double total;

    @Column(name = "client_cpf")
    private String clientCpf;

    @ManyToOne
    @JoinColumn(name = "client_cpf", referencedColumnName = "cpf", insertable = false, updatable = false)
    private ClientEntity client;

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

    public List<SaleItemEntity> getItems() {
        return items;
    }

    public void setItems(List<SaleItemEntity> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public static final class Builder {
        private String code;
        private LocalDate date;
        private List<SaleItemEntity> items;
        private Double total;
        private String clientCpf;
        private ClientEntity client;

        private Builder() {
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder items(List<SaleItemEntity> items) {
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

        public Builder client(ClientEntity client) {
            this.client = client;
            return this;
        }

        public ClientHistoryEntity build() {
            ClientHistoryEntity clientHistoryEntity = new ClientHistoryEntity();
            clientHistoryEntity.setCode(code);
            clientHistoryEntity.setDate(date);
            clientHistoryEntity.setItems(items);
            clientHistoryEntity.setTotal(total);
            clientHistoryEntity.setClientCpf(clientCpf);
            clientHistoryEntity.setClient(client);
            return clientHistoryEntity;
        }
    }
}
