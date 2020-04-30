package com.leonp967.winestore.bo;

import java.util.Objects;

public class SaleItemBO {

    private String productName;
    private String variety;
    private String country;
    private String category;
    private String harvest;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleItemBO that = (SaleItemBO) o;
        return Objects.equals(productName, that.productName) &&
                Objects.equals(variety, that.variety) &&
                Objects.equals(country, that.country) &&
                Objects.equals(category, that.category) &&
                Objects.equals(harvest, that.harvest) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, variety, country, category, harvest, price);
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

        public SaleItemBO build() {
            SaleItemBO saleItemBO = new SaleItemBO();
            saleItemBO.setProductName(productName);
            saleItemBO.setVariety(variety);
            saleItemBO.setCountry(country);
            saleItemBO.setCategory(category);
            saleItemBO.setHarvest(harvest);
            saleItemBO.setPrice(price);
            return saleItemBO;
        }
    }
}
