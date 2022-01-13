package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductTypeEntity {

    @Id
    private String name;

    @OneToMany(mappedBy = "productTypeEntity")
    private List<ClothEntity> clothEntities;

    @ManyToMany(mappedBy = "productTypeEntities")
    private List<LocationEntity> locationEntities;

}
