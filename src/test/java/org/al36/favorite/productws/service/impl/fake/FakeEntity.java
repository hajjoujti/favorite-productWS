package org.al36.favorite.productws.service.impl.fake;

import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.entity.DesignEntity;
import org.al36.favorite.productws.entity.DesignTypeEntity;
import org.al36.favorite.productws.entity.LocationEntity;
import org.al36.favorite.productws.entity.PhotoEntity;
import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.al36.favorite.productws.entity.SizeEntity;
import org.al36.favorite.productws.entity.StockEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeEntity {

    public PhotoEntity photoEntity1;

    public PhotoEntity photoEntity2;

    public PhotoEntity photoEntity3;

    public PhotoEntity photoEntity4;

    public PhotoEntity photoEntity5;

    public PhotoEntity photoEntity6;

    public List<PhotoEntity> photoEntities = new ArrayList<>();

    public SizeEntity sizeEntity1;

    public SizeEntity sizeEntity2;

    public SizeEntity sizeEntity3;

    public SizeEntity sizeEntity4;

    public SizeEntity sizeEntity5;

    public SizeEntity sizeEntity6;

    public List<SizeEntity> sizeEntities = new ArrayList<>();

    public LocationEntity locationEntity1;

    public LocationEntity locationEntity2;

    public LocationEntity locationEntity3;

    public LocationEntity locationEntity4;

    public List<LocationEntity> locationEntities = new ArrayList<>();

    public ProductTypeEntity productTypeEntity1;

    public ProductTypeEntity productTypeEntity2;

    public ProductTypeEntity productTypeEntity3;

    public List<ProductTypeEntity> productTypeEntities = new ArrayList<>();

    public ClothEntity clothEntity1;

    public ClothEntity clothEntity2;

    public List<ClothEntity> clothEntities = new ArrayList<>();

    public StockEntity stockEntity1;

    public StockEntity stockEntity2;

    public StockEntity stockEntity3;

    public StockEntity stockEntity4;

    public StockEntity stockEntity5;

    public StockEntity stockEntity6;

    public List<StockEntity> stockEntities = new ArrayList<>();

    public DesignEntity designEntity1;

    public DesignEntity designEntity2;

    public List<DesignEntity> designEntities = new ArrayList<>();

    public DesignTypeEntity designTypeEntity1;

    public DesignTypeEntity designTypeEntity2;

    public List<DesignTypeEntity> designTypeEntities = new ArrayList<>();

    public FakeEntity() {
        // PHOTO
        photoEntity1 = PhotoEntity.builder().id(1).path("photo-pant1").build();
        photoEntity2 = PhotoEntity.builder().id(2).path("photo-pant2").build();
        photoEntity3 = PhotoEntity.builder().id(3).path("photo-blouse1").build();
        photoEntity4 = PhotoEntity.builder().id(4).path("photo-blouse2").build();
        photoEntity5 = PhotoEntity.builder().id(5).path("photo-design1").build();
        photoEntity6 = PhotoEntity.builder().id(6).path("photo-design2").build();
        photoEntities.addAll(
                List.of(photoEntity1, photoEntity2, photoEntity3, photoEntity4, photoEntity5, photoEntity6));

        // SIZE
        sizeEntity1 = SizeEntity.builder().label("small").build();
        sizeEntity2 = SizeEntity.builder().label("medium").build();
        sizeEntity3 = SizeEntity.builder().label("large").build();
        sizeEntity4 = SizeEntity.builder().label("32").build();
        sizeEntity5 = SizeEntity.builder().label("34").build();
        sizeEntity6 = SizeEntity.builder().label("36").build();
        sizeEntities.addAll(List.of(sizeEntity1, sizeEntity2, sizeEntity3, sizeEntity4, sizeEntity5, sizeEntity6));

        // LOCATION
        locationEntity1 = LocationEntity.builder().label("left-leg").build();
        locationEntity2 = LocationEntity.builder().label("right-leg").build();
        locationEntity3 = LocationEntity.builder().label("left-arm").build();
        locationEntity4 = LocationEntity.builder().label("right-arm").build();
        locationEntities.addAll(List.of(locationEntity1, locationEntity2, locationEntity3, locationEntity4));

        // PRODUCT TYPE
        productTypeEntity1 = ProductTypeEntity.builder()
                                              .name("pant")
                                              .locations(List.of(locationEntity1, locationEntity2))
                                              .build();
        productTypeEntity2 = ProductTypeEntity.builder()
                                              .name("blouse")
                                              .locations(List.of(locationEntity3, locationEntity4))
                                              .build();
        productTypeEntity3 = ProductTypeEntity.builder().name("shirt").build();

        locationEntity1.setProductTypes(List.of(productTypeEntity1));
        locationEntity2.setProductTypes(List.of(productTypeEntity1));
        locationEntity3.setProductTypes(List.of(productTypeEntity2));
        locationEntity4.setProductTypes(List.of(productTypeEntity2));

        productTypeEntities.addAll(List.of(productTypeEntity1, productTypeEntity2, productTypeEntity3));

        // CLOTH
        clothEntity1 = ClothEntity.builder()
                                  .id(1)
                                  .reference("bluePants")
                                  .name("blue pant")
                                  .price(35.99)
                                  .refCreationDate(LocalDateTime.now())
                                  .productType(productTypeEntity1)
                                  .photos(List.of(photoEntity1, photoEntity2))
                                  .build();
        clothEntity2 = ClothEntity.builder()
                                  .id(2)
                                  .reference("greenBlouse")
                                  .name("green blouse")
                                  .price(30.99)
                                  .productType(productTypeEntity2)
                                  .refCreationDate(LocalDateTime.now())
                                  .refDeletionDate(LocalDateTime.now())
                                  .photos(List.of(photoEntity3, photoEntity4))
                                  .build();

        photoEntity1.setCloths(List.of(clothEntity1));
        photoEntity2.setCloths(List.of(clothEntity1));
        photoEntity3.setCloths(List.of(clothEntity2));
        photoEntity4.setCloths(List.of(clothEntity2));

        clothEntities.addAll(List.of(clothEntity1, clothEntity2));

        // STOCK
        stockEntity1 = StockEntity.builder().id(1).quantity(12).cloth(clothEntity1).size(sizeEntity4).build();
        stockEntity2 = StockEntity.builder().id(2).quantity(3).cloth(clothEntity1).size(sizeEntity5).build();
        stockEntity3 = StockEntity.builder().id(3).quantity(2).cloth(clothEntity1).size(sizeEntity6).build();
        stockEntity4 = StockEntity.builder().id(4).quantity(22).cloth(clothEntity2).size(sizeEntity1).build();
        stockEntity5 = StockEntity.builder().id(5).quantity(13).cloth(clothEntity2).size(sizeEntity2).build();
        stockEntity6 = StockEntity.builder().id(6).quantity(0).cloth(clothEntity2).size(sizeEntity3).build();
        stockEntities.addAll(
                List.of(stockEntity1, stockEntity2, stockEntity3, stockEntity4, stockEntity5, stockEntity6));

        // DESIGN
        designEntity1 = DesignEntity.builder()
                                    .id(1)
                                    .name("striped")
                                    .color("black")
                                    .price(4.99)
                                    .photos(List.of(photoEntity5))
                                    .build();
        designEntity2 = DesignEntity.builder()
                                    .id(2)
                                    .name("square")
                                    .color("red")
                                    .price(3.99)
                                    .photos(List.of(photoEntity6))
                                    .build();
        photoEntity5.setDesigns(List.of(designEntity1));
        photoEntity6.setDesigns(List.of(designEntity1));

        designEntities.addAll(List.of(designEntity1, designEntity2));

        // DESIGN TYPE
        designTypeEntity1 = DesignTypeEntity.builder()
                                            .label("leather")
                                            .designs(List.of(designEntity1))
                                            .build();
        designTypeEntity2 = DesignTypeEntity.builder()
                                            .label("fabric")
                                            .designs(List.of(designEntity2))
                                            .build();

        designEntity1.setDesignType(designTypeEntity1);
        designEntity2.setDesignType(designTypeEntity2);

        designTypeEntities.addAll(List.of(designTypeEntity1, designTypeEntity2));
    }

}
