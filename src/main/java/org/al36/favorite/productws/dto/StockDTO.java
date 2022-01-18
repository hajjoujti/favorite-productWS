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
public class StockDTO implements Serializable {

    private static final long serialVersionUID = 5282356533722401153L;

    private Integer id;

    private Integer quantity;

}
