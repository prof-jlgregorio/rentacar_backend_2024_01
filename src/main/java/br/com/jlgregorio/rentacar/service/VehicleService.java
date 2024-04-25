package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public VehicleDto create(VehicleDto dto){
        var model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDto.class);
    }

    public Page<VehicleDto> findByName(String name, Pageable pageable){
        Page<VehicleModel> page = repository.findByNameContainsIgnoreCaseOrderByName(name, pageable);
        return page.map(obj -> CustomModelMapper.parseObject(obj, VehicleDto.class));
    }

}
