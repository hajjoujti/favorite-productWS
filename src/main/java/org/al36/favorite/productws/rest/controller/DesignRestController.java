package org.al36.favorite.productws.rest.controller;

import org.al36.favorite.productws.dto.DesignFullDTO;
import org.al36.favorite.productws.rest.DesignRestOperations;
import org.al36.favorite.productws.rest.message.DesignResponseMessage;
import org.al36.favorite.productws.rest.message.GenericMessage;
import org.al36.favorite.productws.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DesignRestController implements DesignRestOperations {

    private final DesignService designService;

    @Autowired
    public DesignRestController(DesignService designService) {
        this.designService = designService;
    }

    @Override
    public ResponseEntity<Object> getAllDesigns() {
        List<DesignFullDTO> designFullDTOS = designService.getAllDesigns();
        if(designFullDTOS.isEmpty()) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(),
                                       DesignResponseMessage.DESIGNS_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(designFullDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getDesignById(Integer id) {
        DesignFullDTO designFullDTO = designService.getDesignById(id);
        if(designFullDTO == null) {
            return new ResponseEntity<>(
                    new GenericMessage(HttpStatus.NOT_FOUND.toString(), DesignResponseMessage.DESIGN_NOT_FOUND.toString()),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(designFullDTO, HttpStatus.OK);
    }

}
