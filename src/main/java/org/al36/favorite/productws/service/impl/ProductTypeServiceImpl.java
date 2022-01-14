package org.al36.favorite.productws.service.impl;

import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.al36.favorite.productws.repository.ProductTypeRepository;
import org.al36.favorite.productws.service.ProductTypeService;
import org.al36.favorite.productws.utils.DTOConverter;
import org.al36.favorite.productws.utils.EntityConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

    private final EntityConverter entityConverter;

    private final DTOConverter dtoConverter;

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeServiceImpl(EntityConverter entityConverter,
                                  DTOConverter dtoConverter,
                                  ProductTypeRepository productTypeRepository) {
        this.entityConverter = entityConverter;
        this.dtoConverter = dtoConverter;
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public List<ProductTypeDTO> getAllProductTypes() {
        List<ProductTypeDTO> productTypes = new ArrayList<>();
        productTypeRepository.findAll().forEach(
                productType -> productTypes.add(entityConverter.toProductTypeDTO(productType)));
        return productTypes;
    }

    @Override
    public ProductTypeDTO getProductTypeByName(String name) {
        Optional<ProductTypeEntity> productTypeEntity = productTypeRepository.findById(name);
        return productTypeEntity.map(entityConverter::toProductTypeDTO).orElse(null);
    }

}
