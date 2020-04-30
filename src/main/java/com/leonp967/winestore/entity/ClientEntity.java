package com.leonp967.winestore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<ClientHistoryEntity> history;

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ClientHistoryEntity> getHistory() {
        return history;
    }

    public void setHistory(List<ClientHistoryEntity> history) {
        this.history = history;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String cpf;

        private Builder() {
        }

        public static Builder aClientEntity() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientEntity build() {
            ClientEntity clientEntity = new ClientEntity();
            clientEntity.setId(id);
            clientEntity.setName(name);
            clientEntity.setCpf(cpf);
            return clientEntity;
        }
    }
}
