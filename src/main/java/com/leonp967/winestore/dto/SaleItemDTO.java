package com.leonp967.winestore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleItemDTO {

    @JsonProperty("produto")
    private String productName;
    @JsonProperty("variedade")
    private String variety;
    @JsonProperty("pais")
    private String country;
    @JsonProperty("categoria")
    private String category;
    @JsonProperty("safra")
    private String harvest;
    @JsonProperty("preco")
    private Double price;

    public static Builder builder() {
        return new Builder();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String harvest) {
        this.harvest = harvest;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static final class Builder {
        private String productName;
        private String variety;
        private String country;
        private String category;
        private String harvest;
        private Double price;

        private Builder() {
        }

        public static Builder aSaleItemDTO() {
            return new Builder();
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder variety(String variety) {
            this.variety = variety;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder harvest(String harvest) {
            this.harvest = harvest;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public SaleItemDTO build() {
            SaleItemDTO saleItemDTO = new SaleItemDTO();
            saleItemDTO.setProductName(productName);
            saleItemDTO.setVariety(variety);
            saleItemDTO.setCountry(country);
            saleItemDTO.setCategory(category);
            saleItemDTO.setHarvest(harvest);
            saleItemDTO.setPrice(price);
            return saleItemDTO;
        }
    }
}
