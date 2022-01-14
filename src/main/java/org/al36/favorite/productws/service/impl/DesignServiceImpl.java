package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.DesignDTO;
import org.al36.favorite.productws.repository.DesignRepository;
import org.al36.favorite.productws.service.DesignService;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.EntityConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public List<DesignDTO> getAllDesigns() {
        return null;
    }

    @Override
    public DesignDTO getDesignById(Integer id) {
        return null;
    }

    @Override
    public DesignDTO postDesign(DesignDTO design) {
        return null;
    }

}
