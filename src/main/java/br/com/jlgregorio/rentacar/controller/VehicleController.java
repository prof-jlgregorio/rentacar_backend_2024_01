package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping
    public VehicleDto create(@RequestBody VehicleDto dto){
        return service.create(dto);
    }

    @GetMapping("/find")
    public ResponseEntity<PagedModel<VehicleDto>> findByName(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "page", required = true, defaultValue = "0") int page,
            @RequestParam(value = "size", required = true, defaultValue = "10") int size,
            PagedResourcesAssembler<VehicleDto> assembler
    ){
        Pageable pageable = PageRequest.of(page, size);

        Page<VehicleDto> vehicles = service.findByName(name, pageable);

        return new ResponseEntity(assembler.toModel(vehicles), HttpStatus.OK);

    }

}
