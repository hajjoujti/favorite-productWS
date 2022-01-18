package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ClothWithoutStocksAndPhotosDTO;
import org.al36.favorite.productws.dto.SizeWithoutStocksDTO;
import org.al36.favorite.productws.entity.StockEntity;
import org.al36.favorite.productws.repository.StockRepository;
import org.al36.favorite.productws.service.StockService;
import org.al36.favorite.productws.service.impl.fake.FakeEntity;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.DTOConverterImpl;
import org.al36.favorite.productws.utils.EntityConverter;
import org.al36.favorite.productws.utils.EntityConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StockServiceImplTest {

    private final EntityConverter entityConverter = new EntityConverterImpl();

    private final DTOConverter dtoConverter = new DTOConverterImpl();

    private final StockRepository stockRepository = mock(StockRepository.class);

    private final StockService stockService = new StockServiceImpl(entityConverter, dtoConverter, stockRepository);

    private FakeEntity fakeEntity;

    @BeforeEach
    void setUp() {
        fakeEntity = new FakeEntity();
    }

    @Test
    void shouldGetStockByClothAndSize() {
        when(stockRepository.findByClothAndSize(fakeEntity.clothEntity1, fakeEntity.sizeEntity4)).thenReturn(
                Optional.ofNullable(fakeEntity.stockEntity1));

        ClothWithoutStocksAndPhotosDTO clothDTO = entityConverter.toClothWithoutStocksAndPhotos(
                fakeEntity.clothEntity1);
        SizeWithoutStocksDTO sizeDTO = entityConverter.toSizeWithoutStocksDTO(fakeEntity.sizeEntity4);

        assertThat(entityConverter.toStockFullDTO(fakeEntity.stockEntity1)).usingRecursiveComparison().isEqualTo(
                stockService.getStockByClothAndSize(clothDTO, sizeDTO));

        assertNotNull(stockService.getStockByClothAndSize(clothDTO, sizeDTO));

        verify(stockRepository, times(2)).findByClothAndSize(fakeEntity.clothEntity1, fakeEntity.sizeEntity4);
    }

}
