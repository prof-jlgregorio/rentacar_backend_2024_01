package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends
        JpaRepository<BrandModel, Integer> {

    public List<BrandModel> findByNameContainsIgnoreCaseOrderByName(String name);

}
