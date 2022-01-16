package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.DesignFullDTO;
import org.al36.favorite.productws.entity.DesignEntity;
import org.al36.favorite.productws.repository.DesignRepository;
import org.al36.favorite.productws.service.DesignService;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.EntityConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DesignServiceImpl implements DesignService {

    private final EntityConverter entityConverter;

    private final DTOConverter dtoConverter;

    private final DesignRepository designRepository;

    public DesignServiceImpl(EntityConverter entityConverter,
                             DTOConverter dtoConverter,
                             DesignRepository designRepository) {
        this.entityConverter = entityConverter;
        this.dtoConverter = dtoConverter;
        this.designRepository = designRepository;
    }

    @Override
    public List<DesignFullDTO> getAllDesigns() {
        List<DesignFullDTO> designFullDTOS = new ArrayList<>();
        designRepository.findAll().forEach(
                designType -> designFullDTOS.add(entityConverter.toDesignFullDTO(designType)));
        return designFullDTOS;
    }

    @Override
    public DesignFullDTO getDesignById(Integer id) {
        Optional<DesignEntity> designEntity = designRepository.findById(id);
        return designEntity.map(entityConverter::toDesignFullDTO).orElse(null);
    }

}
