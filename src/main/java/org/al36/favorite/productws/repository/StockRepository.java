package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
