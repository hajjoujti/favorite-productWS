package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderLineForProductWSDTO implements Serializable {

    private static final long serialVersionUID = -6993562921572199995L;

    private ClothDTO cloth;

    private SizeDTO size;

    private Integer quantity;

}
