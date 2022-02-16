package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ClothWithoutStocksAndPhotosDTO;
import org.al36.favorite.productws.dto.OrderLineForProductWSDTO;
import org.al36.favorite.productws.dto.SizeWithoutStocksDTO;
import org.al36.favorite.productws.dto.StockFullDTO;
import org.al36.favorite.productws.entity.StockEntity;
import org.al36.favorite.productws.repository.StockRepository;
import org.al36.favorite.productws.service.StockService;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.EntityConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final EntityConverter entityConverter;

    private final DTOConverter dtoConverter;

    private final StockRepository stockRepository;

    public StockServiceImpl(EntityConverter entityConverter,
                            DTOConverter dtoConverter,
                            StockRepository stockRepository) {
        this.entityConverter = entityConverter;
        this.dtoConverter = dtoConverter;
        this.stockRepository = stockRepository;
    }


    @Override
    public StockFullDTO getStockByClothAndSize(ClothWithoutStocksAndPhotosDTO clothWithoutStocksAndPhotosDTO,
                                               SizeWithoutStocksDTO sizeWithoutStocksDTO) {
        StockEntity stockEntity = stockRepository.findByClothAndSize(dtoConverter.toClothEntity(clothWithoutStocksAndPhotosDTO),
                                                                     dtoConverter.toSizeEntity(sizeWithoutStocksDTO))
                                                 .orElse(null);
        return entityConverter.toStockFullDTO(stockEntity);
    }

    @Override
    public StockFullDTO geStockById(Integer id) {
        return entityConverter.toStockFullDTO(stockRepository.findById(id).orElse(null));
    }

    @Override
    public List<StockFullDTO> createUpdatedStockDTOSFromOrderLineDTOS(List<OrderLineForProductWSDTO> orderLines) {
        List<StockFullDTO> stockFullDTOS = new ArrayList<>();
        orderLines.forEach(orderLine -> {
            StockFullDTO stockFullDTO = getStockByClothAndSize(orderLine.getCloth(), orderLine.getSize());
            if(stockFullDTO != null) {
                stockFullDTO.setQuantity(stockFullDTO.getQuantity() - orderLine.getQuantity());
                stockFullDTOS.add(stockFullDTO);
            }
        });
        return stockFullDTOS;
    }

    @Override
    public List<StockFullDTO> updateStocks(List<StockFullDTO> stockFullDTOS) {
        List<StockEntity> stockEntities = new ArrayList<>();
        stockFullDTOS.forEach(stock -> stockEntities.add(dtoConverter.toStockEntity(stock)));
        List<StockFullDTO> finalStockFullDTOS = new ArrayList<>();
        stockRepository.saveAll(stockEntities).forEach(
                stock -> finalStockFullDTOS.add(entityConverter.toStockFullDTO(stock)));
        return finalStockFullDTOS;
    }

}
