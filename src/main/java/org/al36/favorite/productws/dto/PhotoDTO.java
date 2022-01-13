package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PhotoDTO {

    private Integer id;

    private String path;

    private String description;

    private List<ClothDTO> cloths;

    private List<DesignDTO> designs;

}
