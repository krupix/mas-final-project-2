package pl.krupix.mas.pgauto.dto.vehicle;

import lombok.Data;

import java.util.Date;

/**
 * Created by krupix on 02.02.2017.
 */
@Data
public abstract class Vehicle {

    private String manufacturer;

    private String model;

    private String registrationNumber;

    private Integer engingeCapacity;

    private Long mileage;

    private String fuelType;

    private Date productionDate;

    private String VIN;

}
