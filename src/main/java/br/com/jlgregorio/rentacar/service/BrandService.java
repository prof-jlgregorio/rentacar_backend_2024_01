package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.exceptions.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    public BrandModel save(BrandModel model){
        return repository.save(model);
    }

    public BrandModel findById(int id){
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(null));
    }

    public List<BrandModel> findByName(String name){
        return repository.findByNameContainsIgnoreCaseOrderByName(name);
    }

}
