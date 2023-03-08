package br.com.vicente.infrastructure.productadm.persistence;


import br.com.vicente.productadm.domain.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Table(name = "products")
@Entity
public class ProductJPAEntity {

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


    public ProductJPAEntity() {
    }

    public ProductJPAEntity(String id, String name, String description, BigDecimal purchasePrice, Integer stock, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ProductJPAEntity from(ProductEntity aProductEntity) {
        return  new ProductJPAEntity(
                aProductEntity.getId().getId(),
                aProductEntity.getName(),
                aProductEntity.getDescription(),
                aProductEntity.getPurchasePrice(),
                aProductEntity.getStock(),
                aProductEntity.getCreatedAt(),
                aProductEntity.getUpdatedAt()
        );
    }
}
