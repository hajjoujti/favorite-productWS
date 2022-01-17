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
import java.util.Objects;

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
    private List<ProductTypeEntity> productTypes;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return 20;
    }

}

