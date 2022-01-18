package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.ClothWithoutStocksAndPhotosDTO;
import org.al36.favorite.productws.dto.OrderLineForProductWSDTO;
import org.al36.favorite.productws.dto.SizeWithoutStocksDTO;
import org.al36.favorite.productws.dto.StockFullDTO;

import java.util.List;

public interface StockService {

    StockFullDTO getStockByClothAndSize(ClothWithoutStocksAndPhotosDTO clothWithoutStocksAndPhotosDTODTO,
                                        SizeWithoutStocksDTO sizeWithoutStocksDTODTO);

    List<StockFullDTO> createUpdatedStockDTOSFromOrderLineDTOS(List<OrderLineForProductWSDTO> orderLines);

    List<StockFullDTO> updateStocks(List<StockFullDTO> stockFullDTOS);

}
