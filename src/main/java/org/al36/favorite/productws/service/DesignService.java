package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.DesignDTO;

import java.util.List;

public interface DesignService {

    List<DesignDTO> getAllDesigns();

    DesignDTO getDesignById(Integer id);

    DesignDTO postDesign(DesignDTO design);

}
