package br.com.vicente.infrastructure.productadm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAdmProductRepository extends JpaRepository<ProductAdmProductJPAEntity,String> {

}
