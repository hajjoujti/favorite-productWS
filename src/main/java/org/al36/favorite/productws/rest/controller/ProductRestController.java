package org.al36.favorite.productws.rest.controller;

import org.al36.favorite.productws.dto.ClothFullDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.rest.ProductRestOperations;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.al36.favorite.productws.rest.message.ProductTypeResponseMessage;
import org.al36.favorite.productws.rest.message.ProductResponseMessage;
import org.al36.favorite.productws.service.ClothService;
import org.al36.favorite.productws.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController implements ProductRestOperations {


    private final ClothService clothService;

    private final ProductTypeService productTypeService;

    private List<ClothFullDTO> clothFullDTOS;

    @Autowired
    public ProductRestController(ClothService clothService, ProductTypeService productTypeService) {
        this.clothService = clothService;
        this.productTypeService = productTypeService;
    }

    @Override
    public ResponseEntity<Object> getAllClothes() {
        clothFullDTOS = clothService.getAllClothes();
        if(clothFullDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ProductResponseMessage.CLOTHES_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothFullDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllAvailableClothes() {
        clothFullDTOS = clothService.getAllAvailableClothes();
        if(clothFullDTOS.isEmpty()) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ProductResponseMessage.AVAILABLE_CLOTHES_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothFullDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getClotheById(Integer clothId) {
        ClothFullDTO clothFullDTO = clothService.getClotheById(clothId);
        if(clothFullDTO == null) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ProductResponseMessage.CLOTH_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothFullDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getAllClothesByProductType(String productTypeName) {
        ProductTypeDTO productTypeDTO = productTypeService.getProductTypeByName(productTypeName);
        if(productTypeDTO == null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ProductTypeResponseMessage.PRODUCT_TYPE_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }

        clothFullDTOS = clothService.getAllClothesByProductType(productTypeDTO);
        if(clothFullDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                       ProductResponseMessage.CLOTHES_PRODUCT_TYPE_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothFullDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericMessage> postCloth(ClothFullDTO clothFullDTO) {
        if(clothService.getClothByReference(clothFullDTO.getReference()) != null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.CONFLICT.toString(),
                                                           ProductResponseMessage.SAME_REFERENCE_CONFLICT.toString()),
                                        HttpStatus.CONFLICT);
        }
        clothService.saveCloth(clothFullDTO);
        return new ResponseEntity<>(new GenericMessage(HttpStatus.CREATED.toString(),
                                                       ProductResponseMessage.CLOTH_CREATED.toString()),
                                    HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateCloth(ClothFullDTO clothFullDTO) {
        if(clothService.getClotheById(clothFullDTO.getId()) == null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ProductResponseMessage.CLOTH_UPDATE_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothService.saveCloth(clothFullDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericMessage> deleteCloth(Integer clothId) {
        if(clothService.getClotheById(clothId) == null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ProductResponseMessage.CLOTH_DELETE_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }
        clothService.deleteClothById(clothId);
        return new ResponseEntity<>(
                new GenericMessage(HttpStatus.OK.toString(), ProductResponseMessage.CLOTH_DELETED.toString()),
                HttpStatus.OK);
    }

}
