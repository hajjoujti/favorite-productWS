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

}
