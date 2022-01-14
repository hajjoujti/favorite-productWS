package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.repository.ClothRepository;
import org.al36.favorite.productws.service.ClothService;
import org.al36.favorite.productws.service.impl.fakedb.FakeClothServiceEntity;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.DTOConverterImpl;
import org.al36.favorite.productws.utils.EntityConverter;
import org.al36.favorite.productws.utils.EntityConverterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class ClothServiceTest {

    private final EntityConverter entityConverter = new EntityConverterImpl();

    private final DTOConverter dtoConverter = new DTOConverterImpl();

    private final ClothRepository clothRepository = mock(ClothRepository.class);

    private final ClothService clothService = new ClothServiceImpl(entityConverter, dtoConverter, clothRepository);

    FakeClothServiceEntity fakeClothServiceEntity;

    @BeforeEach
    void init() {
        fakeClothServiceEntity = new FakeClothServiceEntity();
    }

    @Test
    void shouldGetAllClothes() {
        when(clothRepository.findAll()).thenReturn(fakeClothServiceEntity.clothEntities);

        assertEquals(2, clothService.getAllClothes().size());

        List<ClothDTO> clothDTOS = new ArrayList<>();
        fakeClothServiceEntity.clothEntities.forEach(cloth -> clothDTOS.add(entityConverter.toClothDTO(cloth)));
        assertThat(clothDTOS).usingRecursiveComparison().isEqualTo(clothService.getAllClothes());

        verify(clothRepository, times(2)).findAll();
    }

    @Test
    void shouldGetAllAvailableClothes() {
        when(clothRepository.findByRefDeletionDateIsNull()).thenReturn(List.of(fakeClothServiceEntity.clothEntity1));

        assertEquals(1, clothService.getAllAvailableClothes().size());

        List<ClothDTO> availableClothDTOS = new ArrayList<>();
        List.of(fakeClothServiceEntity.clothEntity1).forEach(
                cloth -> availableClothDTOS.add(entityConverter.toClothDTO(cloth)));
        assertThat(availableClothDTOS).usingRecursiveComparison().isEqualTo(clothService.getAllAvailableClothes());

        verify(clothRepository, times(2)).findByRefDeletionDateIsNull();

    }

    @Test
    void shouldGetClotheById() {
        when(clothRepository.findById(1)).thenReturn(Optional.ofNullable(fakeClothServiceEntity.clothEntity1));

        assertThat(entityConverter.toClothDTO(fakeClothServiceEntity.clothEntity1)).usingRecursiveComparison().isEqualTo(
                clothService.getClotheById(1));

        assertNotNull(clothService.getClotheById(1));

        assertNull(clothService.getClotheById(3));

        verify(clothRepository, times(2)).findById(1);
        verify(clothRepository, times(1)).findById(3);

    }

    @Test
    void shouldGetClothByReference() {
        when(clothRepository.findByReference("bluePants")).thenReturn(
                Optional.ofNullable(fakeClothServiceEntity.clothEntity1));

        assertThat(entityConverter.toClothDTO(fakeClothServiceEntity.clothEntity1)).usingRecursiveComparison().isEqualTo(
                clothService.getClothByReference("bluePants"));

        assertNotNull(clothService.getClothByReference("bluePants"));

        assertNull(clothService.getClothByReference("yellowPants"));

        verify(clothRepository, times(2)).findByReference("bluePants");
        verify(clothRepository, times(1)).findByReference("yellowPants");

    }

    @Test
    void shouldGetAllClothesByProductType() {
        when(clothRepository.findByRefDeletionDateIsNullAndProductType(
                fakeClothServiceEntity.productTypeEntity1)).thenReturn(
                List.of(fakeClothServiceEntity.clothEntity1));

        assertEquals(1, clothService.getAllClothesByProductType(
                                            entityConverter.toProductTypeDTO(fakeClothServiceEntity.productTypeEntity1))
                                    .size());

        List<ClothDTO> availableClothDTOS = new ArrayList<>();
        List.of(fakeClothServiceEntity.clothEntity1).forEach(
                cloth -> availableClothDTOS.add(entityConverter.toClothDTO(cloth)));
        assertThat(availableClothDTOS).usingRecursiveComparison().isEqualTo(
                clothService.getAllClothesByProductType(
                        entityConverter.toProductTypeDTO(fakeClothServiceEntity.productTypeEntity1)));

        verify(clothRepository, times(2)).findByRefDeletionDateIsNullAndProductType(
                fakeClothServiceEntity.productTypeEntity1);
    }

    @Test
    void shouldUpdateCloth() {
        ClothEntity clothEntity3 = fakeClothServiceEntity.clothEntity2;
        clothEntity3.setPrice(37.99);
        fakeClothServiceEntity.clothEntity2.setPrice(37.99);

        when(clothRepository.save(clothEntity3)).thenReturn(fakeClothServiceEntity.clothEntity2);

        ClothDTO input = entityConverter.toClothDTO(fakeClothServiceEntity.clothEntity2);
        ClothDTO output = clothService.saveCloth(entityConverter.toClothDTO(clothEntity3));

        assertThat(input).usingRecursiveComparison().isEqualTo(output);

        verify(clothRepository, times(1)).save(clothEntity3);
    }

    @Test
    void shouldCreateCloth() {
        ClothEntity clothEntity3 = fakeClothServiceEntity.clothEntity2;
        clothEntity3.setId(null);
        ClothEntity clothEntity4 = clothEntity3;
        clothEntity4.setId(3);

        when(clothRepository.save(clothEntity3)).thenReturn(clothEntity4);

        ClothDTO input = entityConverter.toClothDTO(clothEntity3);
        ClothDTO output = clothService.saveCloth(entityConverter.toClothDTO(clothEntity4));

        assertThat(input).usingRecursiveComparison().isEqualTo(output);

        verify(clothRepository, times(1)).save(clothEntity3);
    }

    @Test
    void deleteClothById() {
        when(clothRepository.findById(1)).thenReturn(Optional.ofNullable(fakeClothServiceEntity.clothEntity1));

        ClothEntity input = clothRepository.findById(1).orElse(new ClothEntity());
        ClothEntity output = clothRepository.findById(1).orElse(new ClothEntity());
        output.setRefDeletionDate(LocalDateTime.now());
        when(clothRepository.save(input)).thenReturn(output);

        assertThat(entityConverter.toClothDTO(output)).usingRecursiveComparison().isEqualTo(
                clothService.deleteClothById(1));

        verify(clothRepository, times(3)).findById(1);
        verify(clothRepository, times(1)).save(input);
    }

}
