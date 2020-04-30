package com.leonp967.winestore.bo;

import java.util.List;
import java.util.Objects;

public class ClientBO {

    private Long id;
    private String name;
    private String cpf;
    private List<ClientHistoryBO> history;

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

    public List<ClientHistoryBO> getHistory() {
        return history;
    }

    public void setHistory(List<ClientHistoryBO> history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientBO clientBO = (ClientBO) o;
        return Objects.equals(id, clientBO.id) &&
                Objects.equals(name, clientBO.name) &&
                Objects.equals(cpf, clientBO.cpf) &&
                Objects.equals(history, clientBO.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, history);
    }

    @Override
    public String toString() {
        return "ClientBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", history=" + history +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String cpf;
        private List<ClientHistoryBO> history;

        private Builder() {
        }

        public static Builder aClientBO() {
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

        public Builder history(List<ClientHistoryBO> history) {
            this.history = history;
            return this;
        }

        public ClientBO build() {
            ClientBO clientBO = new ClientBO();
            clientBO.setId(id);
            clientBO.setName(name);
            clientBO.setCpf(cpf);
            clientBO.setHistory(history);
            return clientBO;
        }
    }
}
