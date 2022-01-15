package org.al36.favorite.productws.persistence;

import org.al36.favorite.productws.entity.ClothEntity;
import org.al36.favorite.productws.entity.DesignEntity;
import org.al36.favorite.productws.entity.DesignTypeEntity;
import org.al36.favorite.productws.entity.LocationEntity;
import org.al36.favorite.productws.entity.PhotoEntity;
import org.al36.favorite.productws.entity.ProductTypeEntity;
import org.al36.favorite.productws.entity.SizeEntity;
import org.al36.favorite.productws.entity.StockEntity;
import org.al36.favorite.productws.repository.ClothRepository;
import org.al36.favorite.productws.repository.DesignTypeRepository;
import org.al36.favorite.productws.repository.ProductTypeRepository;
import org.al36.favorite.productws.repository.SizeRepository;
import org.al36.favorite.productws.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


public class PersistenceData implements CommandLineRunner {

    private final ClothRepository clothRepository;

    private final DesignTypeRepository designTypeRepository;

    private final ProductTypeRepository productTypeRepository;

    private final SizeRepository sizeRepository;

    private final StockRepository stockRepository;

    public PersistenceData(ClothRepository clothRepository,
                           DesignTypeRepository designTypeRepository,
                           ProductTypeRepository productTypeRepository,
                           SizeRepository sizeRepository,
                           StockRepository stockRepository) {
        this.clothRepository = clothRepository;
        this.designTypeRepository = designTypeRepository;
        this.productTypeRepository = productTypeRepository;
        this.sizeRepository = sizeRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData() {
        // PHOTO
        PhotoEntity photoEntity1 = PhotoEntity.builder().path("photo-pant1").build();
        PhotoEntity photoEntity2 = PhotoEntity.builder().path("photo-pant2").build();
        PhotoEntity photoEntity3 = PhotoEntity.builder().path("photo-blouse1").build();
        PhotoEntity photoEntity4 = PhotoEntity.builder().path("photo-blouse2").build();
        PhotoEntity photoEntity5 = PhotoEntity.builder().path("photo-design1").build();
        PhotoEntity photoEntity6 = PhotoEntity.builder().path("photo-design2").build();

        // SIZE
        SizeEntity sizeEntity1 = SizeEntity.builder().label("small").build();
        SizeEntity sizeEntity2 = SizeEntity.builder().label("medium").build();
        SizeEntity sizeEntity3 = SizeEntity.builder().label("large").build();
        SizeEntity sizeEntity4 = SizeEntity.builder().label("32").build();
        SizeEntity sizeEntity5 = SizeEntity.builder().label("34").build();
        SizeEntity sizeEntity6 = SizeEntity.builder().label("36").build();
        sizeRepository.saveAll(List.of(sizeEntity1, sizeEntity2, sizeEntity3, sizeEntity4, sizeEntity5, sizeEntity6));

        // LOCATION
        LocationEntity locationEntity1 = LocationEntity.builder().label("left-leg").build();
        LocationEntity locationEntity2 = LocationEntity.builder().label("right-leg").build();
        LocationEntity locationEntity3 = LocationEntity.builder().label("left-arm").build();
        LocationEntity locationEntity4 = LocationEntity.builder().label("right-arm").build();

        // PRODUCT TYPE
        ProductTypeEntity productTypeEntity1 = ProductTypeEntity.builder()
                                                                .name("pant")
                                                                .locations(List.of(locationEntity1, locationEntity2))
                                                                .build();
        ProductTypeEntity productTypeEntity2 = ProductTypeEntity.builder()
                                                                .name("blouse")
                                                                .locations(List.of(locationEntity3, locationEntity4))
                                                                .build();
        ProductTypeEntity productTypeEntity3 = ProductTypeEntity.builder().name("shirt").build();

        locationEntity1.setProductTypes(List.of(productTypeEntity1));
        locationEntity2.setProductTypes(List.of(productTypeEntity1));
        locationEntity3.setProductTypes(List.of(productTypeEntity2));
        locationEntity4.setProductTypes(List.of(productTypeEntity2));
        productTypeRepository.saveAll(List.of(productTypeEntity1, productTypeEntity2, productTypeEntity3));

        // CLOTH
        ClothEntity clothEntity1 = ClothEntity.builder()
                                              .reference("bluePants")
                                              .name("blue pant")
                                              .price(35.99)
                                              .refCreationDate(LocalDateTime.now())
                                              .productType(productTypeEntity1)
                                              .photos(List.of(photoEntity1, photoEntity2))
                                              .build();
        ClothEntity clothEntity2 = ClothEntity.builder()
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
        clothRepository.saveAll(List.of(clothEntity1, clothEntity2));

        // STOCK
        StockEntity stockEntity1 = StockEntity.builder().quantity(12).cloth(clothEntity1).size(sizeEntity4).build();
        StockEntity stockEntity2 = StockEntity.builder().quantity(3).cloth(clothEntity1).size(sizeEntity5).build();
        StockEntity stockEntity3 = StockEntity.builder().quantity(2).cloth(clothEntity1).size(sizeEntity6).build();
        StockEntity stockEntity4 = StockEntity.builder().quantity(22).cloth(clothEntity2).size(sizeEntity1).build();
        StockEntity stockEntity5 = StockEntity.builder().quantity(13).cloth(clothEntity2).size(sizeEntity2).build();
        StockEntity stockEntity6 = StockEntity.builder().quantity(0).cloth(clothEntity2).size(sizeEntity3).build();
        stockRepository.saveAll(
                List.of(stockEntity1, stockEntity2, stockEntity3, stockEntity4, stockEntity5, stockEntity6));

        // DESIGN
        DesignEntity designEntity1 = DesignEntity.builder()
                                                 .name("striped")
                                                 .color("black")
                                                 .price(4.99)
                                                 .photos(List.of(photoEntity5))
                                                 .build();
        DesignEntity designEntity2 = DesignEntity.builder()
                                                 .name("square")
                                                 .color("red")
                                                 .price(3.99)
                                                 .photos(List.of(photoEntity6))
                                                 .build();

        photoEntity5.setDesigns(List.of(designEntity1));
        photoEntity6.setDesigns(List.of(designEntity1));

        // DESIGN TYPE
        DesignTypeEntity designTypeEntity1 = DesignTypeEntity.builder()
                                                             .label("leather")
                                                             .designs(List.of(designEntity1))
                                                             .build();
        DesignTypeEntity designTypeEntity2 = DesignTypeEntity.builder()
                                                             .label("fabric")
                                                             .designs(List.of(designEntity2))
                                                             .build();

        designEntity1.setDesignType(designTypeEntity1);
        designEntity2.setDesignType(designTypeEntity2);
        designTypeRepository.saveAll(List.of(designTypeEntity1, designTypeEntity2));
    }

}
