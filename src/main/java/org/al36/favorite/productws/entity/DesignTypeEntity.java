package org.al36.favorite.productws.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "design_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DesignTypeEntity {

    @Id
    private String label;

    @OneToMany(mappedBy = "designType", cascade = CascadeType.ALL)
    private List<DesignEntity> designs;

}
