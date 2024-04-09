package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping
    public VehicleDto create(@RequestBody VehicleDto dto){
        return service.create(dto);
    }


}
