package org.al36.favorite.productws.rest;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.al36.favorite.productws.rest.message.ResponseMessage;
import org.al36.favorite.productws.service.ClothService;
import org.al36.favorite.productws.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {


    private final ClothService clothService;

    private final ProductTypeService productTypeService;

    @Autowired
    public ProductRestController(ClothService clothService, ProductTypeService productTypeService) {
        this.clothService = clothService;
        this.productTypeService = productTypeService;
    }

    @RequestMapping("/clothes")
    public ResponseEntity<Object> getAllClothes() {
        List<ClothDTO> clothDTOS = clothService.getAllClothes();
        if(clothDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ResponseMessage.CLOTHES_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTOS, HttpStatus.OK);
    }

    @RequestMapping("/clothes/available")
    public ResponseEntity<Object> getAllAvailableClothes() {
        List<ClothDTO> clothDTOS = clothService.getAllAvailableClothes();
        if(clothDTOS.isEmpty()) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ResponseMessage.AVAILABLE_CLOTHES_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTOS, HttpStatus.OK);
    }

    @RequestMapping("/clothes/{clothId}")
    public ResponseEntity<Object> getClotheById(@PathVariable Integer clothId) {
        ClothDTO clothDTO = clothService.getClotheById(clothId);
        if(clothDTO == null) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ResponseMessage.NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTO, HttpStatus.OK);
    }

    @RequestMapping("/clothes/product-types/{productTypeName}")
    public ResponseEntity<Object> getAllClothesByProductType(@PathVariable String productTypeName) {
        ProductTypeDTO productTypeDTO = productTypeService.getProductTypeByName(productTypeName);
        if(productTypeDTO == null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ResponseMessage.PRODUCT_TYPE_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }

        List<ClothDTO> clothDTOS = clothService.getAllClothesByProductType(productTypeDTO);
        if(clothDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ResponseMessage.NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTOS, HttpStatus.OK);
    }

    @PostMapping("/clothes")
    public ResponseEntity<GenericMessage> postCloth(@RequestBody ClothDTO clothDTO) {
        if(clothService.getClothByReference(clothDTO.getReference()) != null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.CONFLICT.toString(),
                                                           ResponseMessage.SAME_REFERENCE_CONFLICT.toString()),
                                        HttpStatus.CONFLICT);
        }
        clothService.saveCloth(clothDTO);
        return new ResponseEntity<>(new GenericMessage(HttpStatus.CREATED.toString(),
                                                       ResponseMessage.CLOTH_CREATED.toString()),
                                    HttpStatus.CREATED);
    }

    @PutMapping("/clothes")
    public ResponseEntity<Object> updateCloth(@RequestBody ClothDTO clothDTO) {
        if(clothService.getClotheById(clothDTO.getId()) == null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ResponseMessage.CLOTH_UPDATE_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothService.saveCloth(clothDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/clothes/{clothId}")
    public ResponseEntity<GenericMessage> deleteCloth(@PathVariable Integer clothId) {
        if(clothService.getClotheById(clothId) == null) {
            return new ResponseEntity<>(new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                                           ResponseMessage.CLOTH_DELETE_NOT_FOUND.toString()),
                                        HttpStatus.NOT_FOUND);
        }
        clothService.deleteClothById(clothId);
        return new ResponseEntity<>(
                new GenericMessage(HttpStatus.NO_CONTENT.toString(), ResponseMessage.CLOTH_DELETED.toString()),
                HttpStatus.NO_CONTENT);
    }

}
