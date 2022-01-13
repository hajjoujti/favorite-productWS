package org.al36.favorite.productws.rest;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {


    private final ClothService clothService;

    @Autowired
    public ProductRestController(ClothService clothService) {
        this.clothService = clothService;
    }

    @RequestMapping("/cloths")
    public ResponseEntity<?> getAllClothes() {
        List<ClothDTO> clothDTOS = clothService.getAllClothes();
        if(clothDTOS.isEmpty()){
            return new ResponseEntity<>(clothDTOS, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTOS, HttpStatus.OK);
    }

}
