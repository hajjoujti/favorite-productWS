package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {

}
