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

@Entity(name = "size")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SizeEntity {

    @Id
    private String label;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private List<StockEntity> stocks;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        SizeEntity that = (SizeEntity) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return 35;
    }

}
