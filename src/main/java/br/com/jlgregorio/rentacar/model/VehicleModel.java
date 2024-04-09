package br.com.jlgregorio.rentacar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "vehicles")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int year;

    @Column(name = "model_year", nullable = false)
    private int modelYear;

    @Column(nullable = false, length = 30)
    private String color;

    @Column(nullable = false, length = 16)
    private String register;

    @JoinColumn(name = "brand_id", nullable = false)
    @ManyToOne
    private BrandModel brand;

}
