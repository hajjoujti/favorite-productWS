package org.al36.favorite.productws.rest.controller;

import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.rest.ProductTypeRestOperations;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.al36.favorite.productws.rest.message.ProductTypeResponseMessage;
import org.al36.favorite.productws.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductTypeRestController implements ProductTypeRestOperations {

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeRestController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @Override
    public ResponseEntity<Object> getAllProductTypes() {
        List<ProductTypeDTO> productTypeDTOS = productTypeService.getAllProductTypes();
        if(productTypeDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                       ProductTypeResponseMessage.PRODUCT_TYPES_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productTypeDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getProductTypeByName(String name) {
        ProductTypeDTO productTypeDTO = productTypeService.getProductTypeByName(name);
        if(productTypeDTO == null) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ProductTypeResponseMessage.PRODUCT_TYPE_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productTypeDTO, HttpStatus.OK);
    }

}
