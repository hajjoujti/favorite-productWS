package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LocationEntity {

    @Id
    private String label;

    @ManyToMany
    @JoinTable(
            name = "location_product_type",
            joinColumns = @JoinColumn(name = "location_label"),
            inverseJoinColumns = @JoinColumn(name = "product_type_name"))
    private List<ProductTypeEntity> productTypeEntities;

}

