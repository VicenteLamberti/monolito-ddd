package br.com.vicente.productadm.domain;

import br.com.vicente.shared.domain.entity.AggregateRoot;
import br.com.vicente.shared.domain.entity.BaseEntity;
import br.com.vicente.shared.domain.valueobject.IdValueObject;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class ProductEntity extends BaseEntity implements AggregateRoot {

    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private Integer stock;


    private ProductEntity(IdValueObject id, String name, String description, BigDecimal purchasePrice, Integer stock) {
        super(id);
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;

    }
    private ProductEntity(IdValueObject id, String name, String description, BigDecimal purchasePrice, Integer stock,Instant createdAt, Instant updatedAt) {
        super(id,createdAt,updatedAt);
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
    }

    public static ProductEntity with(
            final IdValueObject anId,
            final String name,
            final String description,
            final BigDecimal price,
            final Integer stock,
            final Instant createdAt,
            final Instant updatedAt) {
        return new ProductEntity(
                anId,
                name,
                description,
                price,
                stock,
                createdAt,
                updatedAt
                );
    }

    public static ProductEntity newProductEntity(String name, String description, BigDecimal purchasePrice, Integer stock){
        IdValueObject id = IdValueObject.unique();
        return new ProductEntity(id, name,description,purchasePrice,stock);

    }

    public static ProductEntity newProductEntity(IdValueObject id, String name, String description, BigDecimal purchasePrice, Integer stock){
        return new ProductEntity(id, name,description,purchasePrice,stock);

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
