package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.service.BrandService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
        BrandDto dto = service.findById(id);
        createLinks(dto);
        return dto;
    }

    @GetMapping("/find/{name}")
    public List<BrandDto> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @GetMapping
    public CollectionModel<BrandDto> findAll(){
        CollectionModel<BrandDto> brands = CollectionModel.of(service.findAll());
        for (BrandDto brand: brands){
            createLinks(brand);
        }
        createCollectionLink(brands);
        return brands;
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

//    create the HATEOAS links
    private void createLinks(BrandDto dto){
//        add the self link
        dto.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                                this.getClass()).findById(dto.getId())
                        ).withSelfRel()
                );
//        add the create link
        dto.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                                this.getClass()).delete(dto.getId())
                        ).withRel("delete")
                );
    }
//create the link to collection
    private void createCollectionLink(CollectionModel<BrandDto> brands){
        brands.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                                this.getClass()).findAll()
                ).withRel(IanaLinkRelations.COLLECTION)
        );
    }


}
