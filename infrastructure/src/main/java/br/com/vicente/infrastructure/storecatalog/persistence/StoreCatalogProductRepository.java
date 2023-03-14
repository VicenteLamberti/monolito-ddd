package br.com.vicente.infrastructure.storecatalog.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCatalogProductRepository extends JpaRepository<StoreCatalogProductJPAEntity,String> {

}
