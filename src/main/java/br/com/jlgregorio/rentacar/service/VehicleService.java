package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public VehicleDto create(VehicleDto dto){
        var model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDto.class);
    }

}
