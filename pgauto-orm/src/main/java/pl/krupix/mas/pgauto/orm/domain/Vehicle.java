package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLES")
@Data
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEHICLE_ID")
    private Long id;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "REGISTARTION_NUMBER")
    private String registrationNumber;

    @Column(name = "ENGINGE_CAPACITY")
    private Integer engingeCapacity;

    @Column(name = "MILEAGE")
    private Long mileage;

    @Column(name = "FULE_TYPE")
    private String fuelType;

    @Column(name = "PRODUCTION_DATE")
    private Date productionDate;

    @Column(name = "VIN")
    private String VIN;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;


}
