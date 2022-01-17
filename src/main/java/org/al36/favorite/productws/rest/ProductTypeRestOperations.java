package org.al36.favorite.productws.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product-types")
public interface ProductTypeRestOperations {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getAllProductTypes();

    @GetMapping(value = "/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getProductTypeByName(@PathVariable String name);

}
