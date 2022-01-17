package org.al36.favorite.productws.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/designs")
public interface DesignRestOperations {

    @GetMapping
    ResponseEntity<Object> getAllDesigns();

    @GetMapping(value = "/{id}")
    ResponseEntity<Object> getDesignById(@PathVariable Integer id);

}
