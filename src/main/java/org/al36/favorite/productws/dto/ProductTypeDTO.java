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
public class ProductTypeDTO implements Serializable {

    private static final long serialVersionUID = 6259729076248991549L;

    private String name;

    private List<ClothDTO> clothes;

    private List<LocationDTO> locations;

}
