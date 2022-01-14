package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClothRepository extends JpaRepository<ClothEntity, Integer> {

    Optional<ClothEntity> findByReference(String reference);

    List<ClothEntity> findByRefDeletionDateIsNull();

    List<ClothEntity> findByRefDeletionDateIsNullAndProductType(ProductTypeEntity productTypeEntity);

}
