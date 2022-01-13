package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.ClothDTO;

import java.util.List;

public interface ClothService {

    List<ClothDTO> getAllClothes();

    ClothDTO getClotheById(Integer id);

    ClothDTO postClothe(ClothDTO cloth);

}
