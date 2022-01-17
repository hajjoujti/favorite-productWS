package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "design_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DesignTypeEntity {

    @Id
    private String label;

    @OneToMany(mappedBy = "designType", cascade = CascadeType.ALL)
    private List<DesignEntity> designs;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        DesignTypeEntity that = (DesignTypeEntity) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return 15;
    }

}
