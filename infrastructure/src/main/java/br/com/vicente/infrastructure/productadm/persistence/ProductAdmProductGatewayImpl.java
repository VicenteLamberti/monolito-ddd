package br.com.vicente.infrastructure.productadm.persistence;

import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.productadm.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductAdmProductGatewayImpl implements ProductGateway {

    private final ProductAdmProductRepository productRepository;

    public ProductAdmProductGatewayImpl(final ProductAdmProductRepository productRepository) {
        this.productRepository = Objects.requireNonNull(productRepository);
    }

    @Override
    public void add(ProductEntity productEntity) {
        ProductAdmProductJPAEntity jpaEntity = ProductAdmProductJPAEntity.from(productEntity);
        productRepository.save(jpaEntity);

    }

    @Override
    public Optional<ProductEntity> findById(String id) {

        return productRepository.findById(id).map(ProductAdmProductJPAEntity::toAggregate);
    }
}
