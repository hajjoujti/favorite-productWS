package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ClothFullDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.repository.ClothRepository;
import org.al36.favorite.productws.service.ClothService;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.EntityConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClothServiceImpl implements ClothService {

    private final EntityConverter entityConverter;

    private final DTOConverter dtoConverter;

    private final ClothRepository clothRepository;

    private List<ClothFullDTO> clothFullDTOS;

    public ClothServiceImpl(EntityConverter entityConverter,
                            DTOConverter dtoConverter,
                            ClothRepository clothRepository) {
        this.entityConverter = entityConverter;
        this.dtoConverter = dtoConverter;
        this.clothRepository = clothRepository;
    }

    @Override
    public List<ClothFullDTO> getAllClothes() {
        clothFullDTOS = new ArrayList<>();
        clothRepository.findAll().forEach(cloth -> clothFullDTOS.add(entityConverter.toClothFullDTO(cloth)));
        return clothFullDTOS;
    }

    @Override
    public List<ClothFullDTO> getAllAvailableClothes() {
        clothFullDTOS = new ArrayList<>();
        clothRepository.findByRefDeletionDateIsNull().forEach(
                cloth -> clothFullDTOS.add(entityConverter.toClothFullDTO(cloth)));
        return clothFullDTOS;
    }

    @Override
    public ClothFullDTO getClotheById(Integer id) {
        Optional<ClothEntity> clothEntity = clothRepository.findById(id);
        return clothEntity.map(entityConverter::toClothFullDTO).orElse(null);
    }

    @Override
    public ClothFullDTO getClothByReference(String reference) {
        Optional<ClothEntity> clothEntity = clothRepository.findByReference(reference);
        return clothEntity.map(entityConverter::toClothFullDTO).orElse(null);
    }

    @Override
    public List<ClothFullDTO> getAllClothesByProductType(ProductTypeDTO productTypeDTO) {
        clothFullDTOS = new ArrayList<>();
        clothRepository.findByRefDeletionDateIsNullAndProductType(dtoConverter.toProductTypeEntity(productTypeDTO))
                       .forEach(cloth -> clothFullDTOS.add(entityConverter.toClothFullDTO(cloth)));
        return clothFullDTOS;
    }

    @Override
    public ClothFullDTO saveCloth(ClothFullDTO clothDTO) {
        ClothEntity clothEntity = clothRepository.save(dtoConverter.toClothEntity(clothDTO));
        return entityConverter.toClothFullDTO(clothEntity);
    }

    @Override
    public ClothFullDTO deleteClothById(Integer id) {
        ClothFullDTO clothFullDTO = getClotheById(id);
        clothFullDTO.setRefDeletionDate(LocalDateTime.now());
        return saveCloth(clothFullDTO);
    }

}
