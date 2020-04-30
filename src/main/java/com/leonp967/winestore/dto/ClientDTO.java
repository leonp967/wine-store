package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("cpf")
    private String cpf;

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

    public static final class Builder {
        private Long id;
        private String name;
        private String cpf;

        private Builder() {
        }

        public static ClientDTO.Builder aClientDTO() {
            return new ClientDTO.Builder();
        }

        public ClientDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public ClientDTO.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ClientDTO.Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientDTO build() {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(id);
            clientDTO.setName(name);
            clientDTO.setCpf(cpf);
            return clientDTO;
        }
    }
}
