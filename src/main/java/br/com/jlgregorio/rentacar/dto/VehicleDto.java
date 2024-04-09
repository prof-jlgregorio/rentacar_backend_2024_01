package br.com.jlgregorio.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleDto {

    private int id;

    private String name;

    private int year;

    private int modelYear;

    private String color;

    private String register;

    private BrandDto brand;

}
