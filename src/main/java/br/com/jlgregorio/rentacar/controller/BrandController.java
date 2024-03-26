package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.service.BrandService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService service;

    @PostMapping
    public BrandModel create(@RequestBody BrandModel model){
        return service.create(model);
    }

    @GetMapping("/{id}")
    public BrandModel findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping("/find/{name}")
    public List<BrandModel> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @GetMapping
    public List<BrandModel> findAll(){
        return service.findAll();
    }

    @PutMapping
    public BrandModel update(@RequestBody BrandModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
