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
import java.util.List;

@Entity(name = "design")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DesignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "design_type_label")
    private DesignTypeEntity designType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "design_photo",
            joinColumns = @JoinColumn(name = "design_id"),
            inverseJoinColumns = @JoinColumn(name = "photo_id"))
    private List<PhotoEntity> photos;

}
