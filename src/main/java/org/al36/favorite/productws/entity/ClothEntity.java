package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "cloth", cascade = CascadeType.ALL)
    private List<StockEntity> stocks;

    @ManyToOne
    @JoinColumn(name = "product_type_name")
    private ProductTypeEntity productType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cloth_photo",
            joinColumns = @JoinColumn(name = "cloth_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    private List<PhotoEntity> photos;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ClothEntity that = (ClothEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 5;
    }

}
