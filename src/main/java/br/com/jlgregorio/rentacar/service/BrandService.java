package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.exceptions.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

//    public BrandModel create(BrandModel model){
//        return repository.save(model);
//    }
    public BrandDto create(BrandDto dto){
        BrandModel model = CustomModelMapper.parseObject(dto, BrandModel.class);
        return CustomModelMapper.parseObject(repository.save(model), BrandDto.class);
    }

//    public BrandModel findById(int id){
//        return repository.findById(id).orElseThrow(
//                () -> new ResourceNotFoundException(null));
//    }

    public BrandDto findById(int id){
        BrandModel model = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não Encontrado!")
        );
        return CustomModelMapper.parseObject(model, BrandDto.class);
    }
//this approach returns model objects
//    public List<BrandModel> findByName(String name){
//        return repository.findByNameContainsIgnoreCaseOrderByName(name);
//    }

    public List<BrandDto> findByName(String name){
        List<BrandModel> brands = repository.findByNameContainsIgnoreCaseOrderByName(name);
        return CustomModelMapper.parseObjectList(brands, BrandDto.class);
    }

//    public List<BrandModel> findAll(){ return repository.findAll(); }

    public List<BrandDto> findAll(){
        var brands = repository.findAll();
        return CustomModelMapper.parseObjectList(brands, BrandDto.class);
    }

    public BrandDto update(BrandDto dto){
        BrandModel found = repository.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Não encontrado!"));
        found.setName(dto.getName());
        found.setCountry(dto.getCountry());
        return CustomModelMapper.parseObject(repository.save(found), BrandDto.class);
    }

    public void delete(int id){
        var found = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Não Encontrado"));
        repository.delete(found);
    }

}
