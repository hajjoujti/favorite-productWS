package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "cloth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClothEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String reference;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime refCreationDate;

    @Column()
    private LocalDateTime refDeletionDate;

    @Column(nullable = false)
    private Double price;

    @Column()
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_type_name")
    private ProductTypeEntity productTypeEntity;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private StockEntity stockEntity;

    @ManyToMany
    @JoinTable(
            name = "cloth_photo",
            joinColumns = @JoinColumn(name = "cloth_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    private List<PhotoEntity> photoEntities;

}
