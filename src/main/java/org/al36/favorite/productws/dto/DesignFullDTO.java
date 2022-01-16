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
public class DesignFullDTO implements Serializable {

    private Integer id;

    private String name;

    private String color;

    private Double price;

    private DesignTypeWithoutDesignDTO designType;

    private List<PhotoDTO> photos;

}
