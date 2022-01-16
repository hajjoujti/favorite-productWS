package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.repository.ProductTypeRepository;
import org.al36.favorite.productws.service.ProductTypeService;
import org.al36.favorite.productws.service.impl.fake.FakeEntity;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.DTOConverterImpl;
import org.al36.favorite.productws.utils.EntityConverter;
import org.al36.favorite.productws.utils.EntityConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductTypeServiceImplTest {

    private final EntityConverter entityConverter = new EntityConverterImpl();

    private final DTOConverter dtoConverter = new DTOConverterImpl();

    private final ProductTypeRepository productTypeRepository = mock(ProductTypeRepository.class);

    private final ProductTypeService productTypeService = new ProductTypeServiceImpl(entityConverter, dtoConverter,
                                                                                     productTypeRepository);

    private FakeEntity fakeEntity;

    @BeforeEach
    void setUp() {
        fakeEntity = new FakeEntity();
    }

    @Test
    void shouldGetAllProductTypes() {
        when(productTypeRepository.findAll()).thenReturn(fakeEntity.productTypeEntities);

        assertEquals(3, productTypeService.getAllProductTypes().size());

        List<ProductTypeDTO> productTypeDTOS = new ArrayList<>();
        fakeEntity.productTypeEntities.forEach(
                productType -> productTypeDTOS.add(entityConverter.toProductTypeDTO(productType)));
        assertThat(productTypeDTOS).usingRecursiveComparison().isEqualTo(productTypeService.getAllProductTypes());

        verify(productTypeRepository, times(2)).findAll();
    }

    @Test
    void shouldGetProductTypeByName() {
        when(productTypeRepository.findById("blouse")).thenReturn(Optional.ofNullable(fakeEntity.productTypeEntity1));

        assertThat(entityConverter
                           .toProductTypeDTO(fakeEntity.productTypeEntity1)).usingRecursiveComparison().isEqualTo(
                productTypeService.getProductTypeByName("blouse"));

        assertNotNull(productTypeService.getProductTypeByName("blouse"));

        assertNull(productTypeService.getProductTypeByName("scarf"));

        verify(productTypeRepository, times(2)).findById("blouse");
        verify(productTypeRepository, times(1)).findById("scarf");
    }

}
