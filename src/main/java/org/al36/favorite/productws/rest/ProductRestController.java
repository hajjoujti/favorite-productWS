package org.al36.favorite.productws.rest;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.al36.favorite.productws.rest.message.ResponseMessage;
import org.al36.favorite.productws.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/clothes")
    public ResponseEntity<?> getAllClothes() {
        List<ClothDTO> clothDTOS = clothService.getAllClothes();
        if(clothDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ResponseMessage.NOT_FOUND.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTOS, HttpStatus.OK);
    }

    @RequestMapping("/clothes/{clothId}")
    public ResponseEntity<?> getClotheById(@PathVariable Integer clothId) {
        ClothDTO clothDTO = clothService.getClotheById(clothId);
        if(clothDTO == null) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), ResponseMessage.NOT_FOUND.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothDTO, HttpStatus.OK);
    }

    @PostMapping("/clothes")
    public ResponseEntity<?> postCloth(@RequestBody ClothDTO clothDTO) {
        if(clothService.getClothByReference(clothDTO.getReference()) != null) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.CONFLICT.toString(),
                                       ResponseMessage.SAME_REFERENCE_CONFLICT.getMessage()),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(clothService.postCloth(clothDTO), HttpStatus.OK);
    }

}
