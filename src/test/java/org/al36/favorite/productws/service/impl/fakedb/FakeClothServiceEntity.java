package org.al36.favorite.productws.service.impl.fakedb;

import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.entity.PhotoEntity;
import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.al36.favorite.productws.entity.StockEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeClothServiceEntity {

    public ProductTypeEntity productTypeEntity1;

    public ProductTypeEntity productTypeEntity2;

    public StockEntity stockEntities;

    public List<PhotoEntity> photosEntity;

    public ClothEntity clothEntity1;

    public ClothEntity clothEntity2;

    public List<ClothEntity> clothEntities;

    public FakeClothServiceEntity() {
        this.productTypeEntity1 = ProductTypeEntity.builder().name("pant").build();
        this.productTypeEntity2 = ProductTypeEntity.builder().name("blouse").build();
        this.stockEntities = StockEntity.builder().id(1).quantity(10).build();
        this.photosEntity = new ArrayList<>();
        this.photosEntity.add(PhotoEntity.builder().id(1).path("photo1").build());
        this.photosEntity.add(PhotoEntity.builder().id(2).path("photo2").build());
        this.photosEntity.add(PhotoEntity.builder().id(3).path("photo3").build());
        this.clothEntity1 = ClothEntity.builder()
                                  .id(1)
                                  .reference("bluePants")
                                  .name("blue pant")
                                  .price(35.99)
                                  .refCreationDate(LocalDateTime.now())
                                  .productType(productTypeEntity1)
                                  .stock(stockEntities)
                                  .photos(photosEntity)
                                  .build();
        this.clothEntity2 = ClothEntity.builder()
                                  .id(2)
                                  .reference("greenBlouse")
                                  .name("green blouse")
                                  .price(33.99)
                                  .refCreationDate(LocalDateTime.now())
                                  .refDeletionDate(LocalDateTime.now())
                                  .productType(productTypeEntity2)
                                  .stock(stockEntities)
                                  .photos(photosEntity)
                                  .build();
        this.clothEntities = new ArrayList<>();
        this.clothEntities.add(clothEntity1);
        this.clothEntities.add(clothEntity2);
    }

}
