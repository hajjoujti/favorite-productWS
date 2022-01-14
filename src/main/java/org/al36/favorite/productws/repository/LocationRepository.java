package org.al36.favorite.productws.repository;

import org.al36.favorite.productws.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, String> {

}
