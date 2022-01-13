package org.al36.favorite.productws.utils;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.dto.DesignDTO;
import org.al36.favorite.productws.dto.DesignTypeDTO;
import org.al36.favorite.productws.dto.LocationDTO;
import org.al36.favorite.productws.dto.PhotoDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.dto.SizeDTO;
import org.al36.favorite.productws.dto.StockDTO;
import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.entity.DesignEntity;
import org.al36.favorite.productws.entity.DesignTypeEntity;
import org.al36.favorite.productws.entity.LocationEntity;
import org.al36.favorite.productws.entity.PhotoEntity;
import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.al36.favorite.productws.entity.SizeEntity;
import org.al36.favorite.productws.entity.StockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOConverter {

    ClothEntity ClothEntity(ClothDTO clothDTO);

    DesignEntity toDesignEntity(DesignDTO designDTO);

    DesignTypeEntity toDesignTypeEntity(DesignTypeDTO designTypeDTO);

    LocationEntity toLocationEntity(LocationDTO locationDTO);

    PhotoEntity toPhotoEntity(PhotoDTO photoDTO);

    ProductTypeEntity toProductTypeEntity(ProductTypeDTO productTypeDTO);

    SizeEntity toSizeEntity(SizeDTO sizeDTO);

    StockEntity toStockEntity(StockDTO stockDTO);

}
