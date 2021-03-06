package org.al36.favorite.productws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PhotoDTO implements Serializable {

    private static final long serialVersionUID = -7506563644456157385L;

    private Integer id;

    private String path;

    private String description;

}
