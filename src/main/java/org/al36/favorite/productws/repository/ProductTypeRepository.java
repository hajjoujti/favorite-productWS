package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, String> {

}
