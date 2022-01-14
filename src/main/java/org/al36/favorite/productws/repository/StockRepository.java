package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {

}