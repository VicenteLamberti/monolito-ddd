package br.com.vicente.infrastructure.storecatalog.persistence;


import br.com.vicente.shared.domain.valueobject.IdValueObject;
import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StoreCatalogProductGatewayImpl implements ProductGateway {

    private final StoreCatalogProductRepository productRepository;

    public StoreCatalogProductGatewayImpl(final StoreCatalogProductRepository productRepository) {
        this.productRepository = Objects.requireNonNull(productRepository);
    }


    @Override
    public List<ProductEntity> findAll() {
        List<StoreCatalogProductJPAEntity> products = productRepository.findAll();
        List<ProductEntity> listEntity = new ArrayList<>();
        products.forEach(x->{
            ProductEntity entity = ProductEntity.newProductEntity(IdValueObject.from(x.getId()),x.getName(),x.getDescription(),x.getSalesPrice());
            listEntity.add(entity);
        });
        return listEntity;
    }

    @Override
    public Optional<ProductEntity> find(String id) {
        return Optional.empty();
    }
}
