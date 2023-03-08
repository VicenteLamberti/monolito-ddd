package br.com.vicente.infrastructure.productadm.persistence;

import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.productadm.gateway.ProductGateway;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository productRepository;

    public ProductGatewayImpl(final ProductRepository productRepository) {
        this.productRepository = Objects.requireNonNull(productRepository);
    }

    @Override
    public void add(ProductEntity productEntity) {
        ProductJPAEntity jpaEntity = ProductJPAEntity.from(productEntity);
        productRepository.save(jpaEntity);

    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        return Optional.empty();
    }
}
