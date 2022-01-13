package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClothDTO implements Serializable {

    private Integer id;

    private String reference;

    private String name;

    private LocalDateTime refCreationDate;

    private LocalDateTime refDeletionDate;

    private Double price;

    private String description;

    private List<PhotoDTO> photos;

}
