package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "product_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductTypeEntity {

    @Id
    private String name;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<ClothEntity> cloths;

    @ManyToMany(mappedBy = "productTypes", cascade = CascadeType.ALL)
    private List<LocationEntity> locations;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ProductTypeEntity that = (ProductTypeEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 30;
    }

}
