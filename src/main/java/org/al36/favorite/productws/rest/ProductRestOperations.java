package org.al36.favorite.productws.rest;

import org.al36.favorite.productws.dto.ClothFullDTO;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/clothes")
public interface ProductRestOperations {

    @GetMapping
    ResponseEntity<Object> getAllClothes();

    @GetMapping(value = "/available")
    ResponseEntity<Object> getAllAvailableClothes();

    @GetMapping(value = "/{clothId}")
    ResponseEntity<Object> getClotheById(@PathVariable Integer clothId);

    @GetMapping(value = "/product-types/{productTypeName}")
    ResponseEntity<Object> getAllClothesByProductType(@PathVariable String productTypeName);

    @PostMapping
    ResponseEntity<Object> postCloth(@RequestBody ClothFullDTO clothFullDTO);

    @PutMapping
    ResponseEntity<Object> updateCloth(@RequestBody ClothFullDTO clothFullDTO);

    @DeleteMapping("/{clothId}")
    ResponseEntity<GenericMessage> deleteCloth(@PathVariable Integer clothId);

}
