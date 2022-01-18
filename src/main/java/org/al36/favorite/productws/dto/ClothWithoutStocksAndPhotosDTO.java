package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClothWithoutStocksAndPhotosDTO implements Serializable {

    private static final long serialVersionUID = 8485213344061232177L;

    private Integer id;

    private String reference;

    private String name;

    private LocalDateTime refCreationDate;

    private LocalDateTime refDeletionDate;

    private Double price;

    private String description;

}
