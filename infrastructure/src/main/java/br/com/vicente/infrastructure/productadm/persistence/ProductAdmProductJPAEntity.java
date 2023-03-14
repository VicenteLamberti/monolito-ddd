package br.com.vicente.infrastructure.productadm.persistence;


import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.shared.domain.valueobject.IdValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "products")
@Entity
public class ProductAdmProductJPAEntity {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME", nullable=false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "PURCHASE_PRICE", nullable = false)
    private BigDecimal purchasePrice;
    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "CREATED_AT", nullable = false,columnDefinition = "DATETIME(6)")
    private Instant createdAt;
    @Column(name = "UPDATED_AT", nullable = false,columnDefinition = "DATETIME(6)")
    private Instant updatedAt;


    public ProductAdmProductJPAEntity() {
    }

    public ProductAdmProductJPAEntity(String id, String name, String description, BigDecimal purchasePrice, Integer stock, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ProductAdmProductJPAEntity from(ProductEntity aProductEntity) {
        return  new ProductAdmProductJPAEntity(
                aProductEntity.getId().getId(),
                aProductEntity.getName(),
                aProductEntity.getDescription(),
                aProductEntity.getPurchasePrice(),
                aProductEntity.getStock(),
                aProductEntity.getCreatedAt(),
                aProductEntity.getUpdatedAt()
        );
    }

    public ProductEntity toAggregate() {
        ProductEntity e = ProductEntity.with(
                IdValueObject.from(getId()),
                getName(),
                getDescription(),
                getPurchasePrice(),
                getStock(),
                getCreatedAt(),
                getUpdatedAt()


        );
        return e;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
