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
public class ClothFullDTO implements Serializable {

    private static final long serialVersionUID = 3573799833897001257L;

    private Integer id;

    private String reference;

    private String name;

    private LocalDateTime refCreationDate;

    private LocalDateTime refDeletionDate;

    private Double price;

    private String description;

    private ProductTypeWithoutClothesDTO productType;

    private List<PhotoDTO> photos;

    private List<StockWithSizeDTO> stocks;

}
