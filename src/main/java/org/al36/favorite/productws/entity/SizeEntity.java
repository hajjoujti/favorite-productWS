package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "size")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SizeEntity {

    @Id
    private String label;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private StockEntity stockEntity;

}
