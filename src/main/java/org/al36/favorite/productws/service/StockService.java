package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.dto.OrderLineForProductWSDTO;
import org.al36.favorite.productws.dto.SizeDTO;
import org.al36.favorite.productws.dto.StockFullDTO;

import java.util.List;

public interface StockService {

    StockFullDTO getStockByClothAndSize(ClothDTO clothDTO, SizeDTO sizeDTO);

    List<StockFullDTO> createUpdatedStockDTOSFromOrderLineDTOS(List<OrderLineForProductWSDTO> orderLines);

    List<StockFullDTO> updateStocks(List<StockFullDTO> stockFullDTOS);

}
