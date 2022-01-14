package org.al36.favorite.productws.service.serviceImpl;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.repository.ClothRepository;
import org.al36.favorite.productws.service.ClothService;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.EntityConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClothServiceImpl implements ClothService {

    private final EntityConverter entityConverter;

    private final DTOConverter dtoConverter;

    private final ClothRepository clothRepository;

    public ClothServiceImpl(EntityConverter entityConverter,
                            DTOConverter dtoConverter,
                            ClothRepository clothRepository) {
        this.entityConverter = entityConverter;
        this.dtoConverter = dtoConverter;
        this.clothRepository = clothRepository;
    }

    @Override
    public List<ClothDTO> getAllClothes() {
        List<ClothDTO> clothsDTOS = new ArrayList<>();
        clothRepository.findAll().forEach((cloth) -> clothsDTOS.add(entityConverter.toClothDTO(cloth)));
        System.out.println(clothsDTOS);
        return clothsDTOS;
    }

    @Override
    public ClothDTO getClotheById(Integer id) {
        Optional<ClothEntity> clothEntity = clothRepository.findById(id);
        return clothEntity.map(entityConverter::toClothDTO).orElse(null);
    }

    @Override
    public ClothDTO postCloth(ClothDTO clothDTO) {
        ClothEntity clothEntity = dtoConverter.ClothEntity(clothDTO);
        clothEntity = clothRepository.save(clothEntity);
        return entityConverter.toClothDTO(clothEntity);
    }

    @Override
    public ClothDTO getClothByReference(String reference) {
        Optional<ClothEntity> clothEntity = clothRepository.findByReference(reference);
        return clothEntity.map(entityConverter::toClothDTO).orElse(null);
    }

}
