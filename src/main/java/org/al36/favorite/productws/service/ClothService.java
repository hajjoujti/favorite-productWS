package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.ClothFullDTO;
import org.al36.favorite.productws.dto.ProductTypeDTO;

import java.util.List;

public interface ClothService {

    List<ClothFullDTO> getAllClothes();

    List<ClothFullDTO> getAllAvailableClothes();

    ClothFullDTO getClotheById(Integer id);

    ClothFullDTO getClothByReference(String reference);

    List<ClothFullDTO> getAllClothesByProductType(ProductTypeDTO productTypeDTO);

    ClothFullDTO saveCloth(ClothFullDTO clothDTO);

    ClothFullDTO deleteClothById(Integer id);

}
