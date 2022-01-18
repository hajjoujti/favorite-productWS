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
public class StockWithSizeDTO implements Serializable {

    private static final long serialVersionUID = 1337142737817738659L;

    private Integer id;

    private Integer quantity;

    private SizeWithoutStocksDTO size;

}
