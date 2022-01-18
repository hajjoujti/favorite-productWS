package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.entity.SizeEntity;
import org.al36.favorite.productws.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {

    Optional<StockEntity> findByClothAndSize(ClothEntity clothEntity, SizeEntity sizeEntity);

}
