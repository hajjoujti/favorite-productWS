package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.DesignFullDTO;
import org.al36.favorite.productws.repository.DesignRepository;
import org.al36.favorite.productws.service.DesignService;
import org.al36.favorite.productws.service.impl.fake.FakeEntity;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.DTOConverterImpl;
import org.al36.favorite.productws.utils.EntityConverter;
import org.al36.favorite.productws.utils.EntityConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class DesignServiceImplTest {

    private final EntityConverter entityConverter = new EntityConverterImpl();

    private final DTOConverter dtoConverter = new DTOConverterImpl();

    private final DesignRepository designRepository = mock(DesignRepository.class);

    private final DesignService designService = new DesignServiceImpl(entityConverter, dtoConverter, designRepository);

    private FakeEntity fakeEntity;

    @BeforeEach
    void setUp() {
        fakeEntity = new FakeEntity();
    }

    @Test
    void shouldGetAllDesigns() {
        when(designRepository.findAll()).thenReturn(fakeEntity.designEntities);

        assertEquals(2, designService.getAllDesigns().size());

        List<DesignFullDTO> designFullDTOS = new ArrayList<>();
        fakeEntity.designEntities.forEach(design -> designFullDTOS.add(entityConverter.toDesignFullDTO(design)));
        assertThat(designFullDTOS).usingRecursiveComparison().isEqualTo(designService.getAllDesigns());

        verify(designRepository, times(2)).findAll();
    }

    @Test
    void shouldGetDesignById() {
        when(designRepository.findById(1)).thenReturn(Optional.ofNullable(fakeEntity.designEntity1));

        assertThat(entityConverter.toDesignFullDTO(fakeEntity.designEntity1)).usingRecursiveComparison().isEqualTo(
                designService.getDesignById(1));

        assertNotNull(designService.getDesignById(1));

        assertNull(designService.getDesignById(3));

        verify(designRepository, times(2)).findById(1);
        verify(designRepository, times(1)).findById(3);
    }

}
