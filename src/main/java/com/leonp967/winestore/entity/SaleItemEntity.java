package com.leonp967.winestore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sale_item")
@SequenceGenerator(name = "sale_item_seq")
public class SaleItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_item_seq")
    @Column(name = "sale_item_id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "variety")
    private String variety;

    @Column(name = "country")
    private String country;

    @Column(name = "category")
    private String category;

    @Column(name = "harvest")
    private String harvest;

    @Column(name = "price")
    private Double price;

    @Column(name = "history_code")
    private String historyCode;

    @ManyToOne
    @JoinColumn(name = "history_code", referencedColumnName = "code", insertable = false, updatable = false)
    private ClientHistoryEntity clientHistory;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientHistoryEntity getClientHistory() {
        return clientHistory;
    }

    public void setClientHistory(ClientHistoryEntity clientHistory) {
        this.clientHistory = clientHistory;
    }

    public String getHistoryCode() {
        return historyCode;
    }

    public void setHistoryCode(String historyCode) {
        this.historyCode = historyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleItemEntity that = (SaleItemEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(variety, that.variety) &&
                Objects.equals(country, that.country) &&
                Objects.equals(category, that.category) &&
                Objects.equals(harvest, that.harvest) &&
                Objects.equals(price, that.price) &&
                Objects.equals(historyCode, that.historyCode) &&
                Objects.equals(clientHistory, that.clientHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, variety, country, category, harvest, price, historyCode, clientHistory);
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

        public SaleItemEntity build() {
            SaleItemEntity saleItemBO = new SaleItemEntity();
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
