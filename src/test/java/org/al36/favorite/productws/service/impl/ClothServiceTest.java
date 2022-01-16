package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ClothFullDTO;
import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.repository.ClothRepository;
import org.al36.favorite.productws.service.ClothService;
import org.al36.favorite.productws.service.impl.fake.FakeEntity;
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

    private FakeEntity fakeEntity;

    @BeforeEach
    void init() {
        fakeEntity = new FakeEntity();
    }

    @Test
    void shouldGetAllClothes() {
        when(clothRepository.findAll()).thenReturn(fakeEntity.clothEntities);

        assertEquals(2, clothService.getAllClothes().size());

        List<ClothFullDTO> clothFullDTO = new ArrayList<>();
        fakeEntity.clothEntities.forEach(cloth -> clothFullDTO.add(entityConverter.toClothFullDTO(cloth)));
        assertThat(clothFullDTO).usingRecursiveComparison().isEqualTo(clothService.getAllClothes());

        verify(clothRepository, times(2)).findAll();
    }

    @Test
    void shouldGetAllAvailableClothes() {
        when(clothRepository.findByRefDeletionDateIsNull()).thenReturn(List.of(fakeEntity.clothEntity1));

        assertEquals(1, clothService.getAllAvailableClothes().size());

        List<ClothFullDTO> availableClothDTOS = new ArrayList<>();
        List.of(fakeEntity.clothEntity1).forEach(
                cloth -> availableClothDTOS.add(entityConverter.toClothFullDTO(cloth)));
        assertThat(availableClothDTOS).usingRecursiveComparison().isEqualTo(clothService.getAllAvailableClothes());

        verify(clothRepository, times(2)).findByRefDeletionDateIsNull();

    }

    @Test
    void shouldGetClotheById() {
        when(clothRepository.findById(1)).thenReturn(Optional.ofNullable(fakeEntity.clothEntity1));

        assertThat(entityConverter.toClothFullDTO(fakeEntity.clothEntity1)).usingRecursiveComparison().isEqualTo(
                clothService.getClotheById(1));

        assertNotNull(clothService.getClotheById(1));

        assertNull(clothService.getClotheById(3));

        verify(clothRepository, times(2)).findById(1);
        verify(clothRepository, times(1)).findById(3);

    }

    @Test
    void shouldGetClothByReference() {
        when(clothRepository.findByReference("bluePants")).thenReturn(
                Optional.ofNullable(fakeEntity.clothEntity1));

        assertThat(entityConverter.toClothFullDTO(fakeEntity.clothEntity1)).usingRecursiveComparison().isEqualTo(
                clothService.getClothByReference("bluePants"));

        assertNotNull(clothService.getClothByReference("bluePants"));

        assertNull(clothService.getClothByReference("yellowPants"));

        verify(clothRepository, times(2)).findByReference("bluePants");
        verify(clothRepository, times(1)).findByReference("yellowPants");

    }

    @Test
    void shouldGetAllClothesByProductType() {
        when(clothRepository.findByRefDeletionDateIsNullAndProductType(
                fakeEntity.productTypeEntity1)).thenReturn(
                List.of(fakeEntity.clothEntity1));

        assertEquals(1, clothService.getAllClothesByProductType(
                                            entityConverter.toProductTypeDTO(fakeEntity.productTypeEntity1))
                                    .size());

        List<ClothFullDTO> availableClothFullDTOS = new ArrayList<>();
        List.of(fakeEntity.clothEntity1).forEach(
                cloth -> availableClothFullDTOS.add(entityConverter.toClothFullDTO(cloth)));
        assertThat(availableClothFullDTOS).usingRecursiveComparison().isEqualTo(
                clothService.getAllClothesByProductType(
                        entityConverter.toProductTypeDTO(fakeEntity.productTypeEntity1)));

        verify(clothRepository, times(2)).findByRefDeletionDateIsNullAndProductType(
                fakeEntity.productTypeEntity1);
    }

    @Test
    void shouldUpdateCloth() {
        ClothEntity clothEntity3 = fakeEntity.clothEntity2;
        clothEntity3.setPrice(37.99);
        fakeEntity.clothEntity2.setPrice(37.99);

        when(clothRepository.save(clothEntity3)).thenReturn(fakeEntity.clothEntity2);

        ClothFullDTO input = entityConverter.toClothFullDTO(fakeEntity.clothEntity2);
        ClothFullDTO output = clothService.saveCloth(entityConverter.toClothFullDTO(clothEntity3));

        assertThat(input).usingRecursiveComparison().isEqualTo(output);

        verify(clothRepository, times(1)).save(clothEntity3);
    }

    @Test
    void shouldCreateCloth() {
        ClothEntity clothEntity3 = fakeEntity.clothEntity2;
        clothEntity3.setId(null);
        ClothEntity clothEntity4 = clothEntity3;
        clothEntity4.setId(3);

        when(clothRepository.save(clothEntity3)).thenReturn(clothEntity4);

        ClothFullDTO input = entityConverter.toClothFullDTO(clothEntity3);
        ClothFullDTO output = clothService.saveCloth(entityConverter.toClothFullDTO(clothEntity4));

        assertThat(input).usingRecursiveComparison().isEqualTo(output);

        verify(clothRepository, times(1)).save(clothEntity3);
    }

    @Test
    void deleteClothById() {
        when(clothRepository.findById(1)).thenReturn(Optional.ofNullable(fakeEntity.clothEntity1));

        ClothEntity input = clothRepository.findById(1).orElse(new ClothEntity());
        ClothEntity output = clothRepository.findById(1).orElse(new ClothEntity());
        output.setRefDeletionDate(LocalDateTime.now());
        when(clothRepository.save(input)).thenReturn(output);

        assertThat(entityConverter.toClothFullDTO(output)).usingRecursiveComparison().isEqualTo(
                clothService.deleteClothById(1));

        verify(clothRepository, times(3)).findById(1);
        verify(clothRepository, times(1)).save(input);
    }

}
