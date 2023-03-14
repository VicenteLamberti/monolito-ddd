package br.com.vicente.infrastructure.storecatalog.persistence;


import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.shared.domain.valueobject.IdValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Table(name = "products")
@Entity
public class StoreCatalogProductJPAEntity {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME", nullable=false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "PURCHASE_PRICE", nullable = false)
    private BigDecimal salesPrice;





    public StoreCatalogProductJPAEntity() {
    }

    public StoreCatalogProductJPAEntity(String id, String name, String description, BigDecimal salesPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salesPrice = salesPrice;

    }

    public static StoreCatalogProductJPAEntity from(ProductEntity aProductEntity) {
        return  new StoreCatalogProductJPAEntity(
                aProductEntity.getId().getId(),
                aProductEntity.getName(),
                aProductEntity.getDescription(),
                aProductEntity.getPurchasePrice()

        );
    }

    public ProductEntity toAggregate() {
        ProductEntity e = ProductEntity.with(
                IdValueObject.from(getId()),
                getName(),
                getDescription(),
                getSalesPrice(),
                null,
                null,
                null


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

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }


}
