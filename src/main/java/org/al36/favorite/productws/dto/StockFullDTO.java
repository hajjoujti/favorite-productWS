package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StockFullDTO implements Serializable {

    private static final long serialVersionUID = 6122055746987497421L;

    private Integer id;

    private Integer quantity;

    private ClothWithoutStocksAndPhotosDTO cloth;

    private SizeWithoutStocksDTO size;

}
