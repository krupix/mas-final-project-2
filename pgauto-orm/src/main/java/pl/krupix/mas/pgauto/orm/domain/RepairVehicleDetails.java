package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.vehicle.CarDTO;
import pl.krupix.mas.pgauto.api.dto.vehicle.MotocycleDTO;
import pl.krupix.mas.pgauto.api.dto.vehicle.VehicleRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by krupix on 06.02.2017.
 */
@Entity
@Table(name = "REPAIR_VEHICLE_DETAILS")
@Data
public class RepairVehicleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPAIR_VEHICLE_DETAILS_ID")
    private Long id;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "REPAIR_ID")
    private Repair repair;

    public VehicleRepairDetailsDTO getDTO() throws ParameterNotFoundException {

        VehicleRepairDetailsDTO dto = new VehicleRepairDetailsDTO();

        dto.setId(id);
        dto.setDescription(description);
        dto.setEndDate(endDate);
        dto.setStartDate(startDate);
        dto.setRepairDTO(repair.getDTO());

        if (vehicle instanceof Car) {
            dto.setVehicleDTO(CarDTO.createCar(vehicle.getClient().getDTO(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getRegistrationNumber(), vehicle.getEngingeCapacity(), vehicle.getMileage(), vehicle.getFuelType(), vehicle.getProductionDate(), vehicle.getVIN(), ((Car) vehicle).getBodyType()));
        } else if (vehicle instanceof Motocycle) {
            dto.setVehicleDTO(MotocycleDTO.createMotocycle(vehicle.getClient().getDTO(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getRegistrationNumber(), vehicle.getEngingeCapacity(), vehicle.getMileage(), vehicle.getFuelType(), vehicle.getProductionDate(), vehicle.getVIN(), ((Motocycle) vehicle).getMotocycleType()));
        }

        return dto;
    }
}

