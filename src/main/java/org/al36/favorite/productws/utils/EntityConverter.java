package org.al36.favorite.productws.utils;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.dto.ClothFullDTO;
import org.al36.favorite.productws.dto.DesignDTO;
import org.al36.favorite.productws.dto.DesignFullDTO;
import org.al36.favorite.productws.dto.DesignTypeDTO;
import org.al36.favorite.productws.dto.LocationDTO;
import org.al36.favorite.productws.dto.PhotoDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;
import org.al36.favorite.productws.dto.ProductTypeWithoutClothesDTO;
import org.al36.favorite.productws.dto.SizeDTO;
import org.al36.favorite.productws.dto.SizeWithoutStocksDTO;
import org.al36.favorite.productws.dto.StockDTO;
import org.al36.favorite.productws.dto.StockFullDTO;
import org.al36.favorite.productws.dto.StockWithSizeDTO;
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
public interface EntityConverter {

    ClothDTO toClothDTO(ClothEntity clothEntity);

    ClothFullDTO toClothFullDTO(ClothEntity clothEntity);

    DesignDTO toDesignDTO(DesignEntity designEntity);

    DesignTypeDTO toDesignTypeDTO(DesignTypeEntity designTypeEntity);

    DesignFullDTO toDesignFullDTO(DesignEntity designType);

    LocationDTO toLocationDTO(LocationEntity locationEntity);

    PhotoDTO toPhotoDTO(PhotoEntity photoEntity);

    ProductTypeDTO toProductTypeDTO(ProductTypeEntity productTypeEntity);

    ProductTypeWithoutClothesDTO toProductWithoutClothesTypeDTO(ProductTypeEntity productTypeEntity);

    SizeDTO toSizeDTO(SizeEntity sizeEntity);

    SizeWithoutStocksDTO toSizeWithoutStocksDTO(SizeEntity sizeEntity);

    StockDTO toStockDTO(StockEntity stockEntity);

    StockFullDTO toStockFullDTO(StockEntity stockEntity);

    StockWithSizeDTO toStockWithSizeDTO(StockEntity stockEntity);

}
