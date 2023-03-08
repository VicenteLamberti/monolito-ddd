package br.com.vicente.infrastructure.repository;


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
    @Column(name = "ACTIVE", nullable = false)
    private BigDecimal purchasePrice;
    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "CREATED_AT", nullable = false,columnDefinition = "DATETIME(6)")
    private Instant createdAt;
    @Column(name = "UPDATED_AT", nullable = false,columnDefinition = "DATETIME(6)")
    private Instant updatedAt;




}
