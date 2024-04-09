package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.service.BrandService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private BrandService service;
    @PostMapping
    public BrandDto create(@RequestBody BrandDto dto){
        return service.create(dto);
    }

//    @GetMapping("/{id}")
//    public BrandModel findById(@PathVariable("id") int id){
//        return service.findById(id);
//    }
    @GetMapping("/{id}")
    public BrandDto findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping("/find/{name}")
    public List<BrandDto> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @GetMapping
    public List<BrandDto> findAll(){
        return service.findAll();
    }

    @PutMapping
    public BrandDto update(@RequestBody BrandDto dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
