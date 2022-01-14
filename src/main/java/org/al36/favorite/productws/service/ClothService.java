package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.ClothDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;

import java.util.List;

public interface ClothService {

    List<ClothDTO> getAllClothes();

    List<ClothDTO> getAllAvailableClothes();

    ClothDTO getClotheById(Integer id);

    ClothDTO getClothByReference(String reference);

    List<ClothDTO> getAllClothesByProductType(ProductTypeDTO productTypeDTO);

    ClothDTO saveCloth(ClothDTO clothDTO);

    ClothDTO deleteClothById(Integer id);

}
