package org.al36.favorite.productws.rest;

import org.al36.favorite.productws.dto.StockFullDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/stocks")
public interface StockRestOperations {

    @PutMapping
    ResponseEntity<Object> updateStocks(@RequestBody List<StockFullDTO> stockDTOS);

}
