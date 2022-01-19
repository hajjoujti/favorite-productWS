package org.al36.favorite.productws.rest.controller;

import org.al36.favorite.productws.dto.StockDTO;
import org.al36.favorite.productws.dto.StockFullDTO;
import org.al36.favorite.productws.rest.StockRestOperations;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.al36.favorite.productws.rest.message.StockResponseMessage;
import org.al36.favorite.productws.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockRestController implements StockRestOperations {

    private final StockService stockService;

    @Autowired
    public StockRestController(StockService stockService) {
        this.stockService = stockService;
    }


    @Override
    public ResponseEntity<Object> updateStocks(List<StockDTO> stockDTOS) {
        List<StockFullDTO> stockFullDTOS = new ArrayList<>();
        for(StockDTO stock : stockDTOS) {
            StockFullDTO stockFullDTO = stockService.geStockById(stock.getId());
            if(stockFullDTO == null){
                return new ResponseEntity<>(
                        new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                           StockResponseMessage.STOCK_NOT_FOUND.toString()),
                        HttpStatus.NOT_FOUND);
            }
            stockFullDTO.setQuantity(stockFullDTO.getQuantity() - stock.getQuantity());
            stockFullDTOS.add(stockFullDTO);
        }

        if(stockFullDTOS.isEmpty()){
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                       StockResponseMessage.STOCKS_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stockService.updateStocks(stockFullDTOS), HttpStatus.OK);
    }

}
