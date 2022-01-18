package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SizeDTO implements Serializable {

    private static final long serialVersionUID = 5959195615151727682L;

    private String label;

    private List<StockDTO> stocks;

}
