package br.com.vicente.storecatalog.domain;

import br.com.vicente.shared.domain.entity.AggregateRoot;
import br.com.vicente.shared.domain.entity.BaseEntity;
import br.com.vicente.shared.domain.valueobject.IdValueObject;

import java.math.BigDecimal;
import java.time.Instant;

public class ProductEntity extends BaseEntity implements AggregateRoot {

    private String name;
    private String description;
    private BigDecimal salesPrice;

    private ProductEntity(IdValueObject id, String name, String description, BigDecimal salesPrice) {
        super(id);
        this.name = name;
        this.description = description;
        this.salesPrice = salesPrice;
    }

    public static ProductEntity newProductEntity(IdValueObject id, String name, String description, BigDecimal salesPrice){
        return  new ProductEntity(id,name,description,salesPrice);
    }

    public static ProductEntity with(
            final IdValueObject anId,
            final String name,
            final String description,
            final BigDecimal price
  ) {
        return new ProductEntity(
                anId,
                name,
                description,
                price

        );
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
