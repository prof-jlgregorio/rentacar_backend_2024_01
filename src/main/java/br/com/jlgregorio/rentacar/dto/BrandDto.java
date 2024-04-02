package br.com.jlgregorio.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BrandDto {

    private int id;

    private String name;

    private String country;

    public String getFullName(){
        return this.name + " - " + this.country;
    }

}
