package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.ProductTypeDTO;

import java.util.List;

public interface ProductTypeService {

    List<ProductTypeDTO> getAllProductTypes();

    ProductTypeDTO getProductTypeByName(String name);

}
