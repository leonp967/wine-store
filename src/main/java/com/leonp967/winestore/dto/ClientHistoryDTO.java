package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ClientHistoryDTO {

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JsonProperty("itens")
    private List<SaleItemDTO> items;

    @JsonProperty("valorTotal")
    private Double total;

    @JsonProperty("cliente")
    private String client;

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

    public List<SaleItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SaleItemDTO> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHistoryDTO that = (ClientHistoryDTO) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(date, that.date) &&
                Objects.equals(items, that.items) &&
                Objects.equals(total, that.total) &&
                Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, date, items, total, client);
    }

    public static final class Builder {
        private String code;
        private LocalDate date;
        private List<SaleItemDTO> items;
        private Double total;
        private String client;

        private Builder() {
        }

        public static Builder aClientHistoryDTO() {
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

        public Builder items(List<SaleItemDTO> items) {
            this.items = items;
            return this;
        }

        public Builder total(Double total) {
            this.total = total;
            return this;
        }

        public Builder client(String client) {
            this.client = client;
            return this;
        }

        public ClientHistoryDTO build() {
            ClientHistoryDTO clientHistoryDTO = new ClientHistoryDTO();
            clientHistoryDTO.setCode(code);
            clientHistoryDTO.setDate(date);
            clientHistoryDTO.setItems(items);
            clientHistoryDTO.setTotal(total);
            clientHistoryDTO.setClient(client);
            return clientHistoryDTO;
        }
    }
}
