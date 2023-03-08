package br.com.vicente.productadm.domain;

import br.com.vicente.shared.domain.entity.AggregateRoot;
import br.com.vicente.shared.domain.entity.BaseEntity;
import br.com.vicente.shared.domain.valueobject.IdValueObject;

import java.math.BigDecimal;

public class ProductEntity extends BaseEntity implements AggregateRoot {

    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private Integer stock;

    public ProductEntity(String name, String description, BigDecimal purchasePrice, Integer stock) {
        super();
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
    }
    public ProductEntity(IdValueObject id, String name, String description, BigDecimal purchasePrice, Integer stock) {
        super(id);
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}