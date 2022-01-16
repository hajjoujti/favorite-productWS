package org.al36.favorite.productws.service;

import org.al36.favorite.productws.dto.DesignFullDTO;

import java.util.List;

public interface DesignService {

    List<DesignFullDTO> getAllDesigns();

    DesignFullDTO getDesignById(Integer id);

}
