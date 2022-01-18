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
public class ProductTypeWithoutClothesDTO implements Serializable {

    private static final long serialVersionUID = -1649192758431878006L;

    private String name;

    private List<LocationDTO> locations;

}
