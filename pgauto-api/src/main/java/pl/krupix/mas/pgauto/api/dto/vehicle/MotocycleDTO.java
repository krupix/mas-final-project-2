package pl.krupix.mas.pgauto.api.dto.vehicle;

import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;
import pl.krupix.mas.pgauto.api.dto.person.ClientDTO;

import java.util.Date;

/**
 * Created by krupix on 03.02.2017.
 */
public class MotocycleDTO extends VehicleDTO {

    private MotocycleTypes type;


    public MotocycleDTO(String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, MotocycleTypes type) {
        super(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN);
        this.type = type;
    }

    public static MotocycleDTO createMotocycle(ClientDTO clientDTO, String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, MotocycleTypes type) throws ParameterNotFoundException {

        if (clientDTO == null) {
            throw new ParameterNotFoundException("clientDTO");
        }

        MotocycleDTO motocycleDTO = new MotocycleDTO(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN, type);
        clientDTO.addMotocycle(motocycleDTO);

        return motocycleDTO;
    }


    public MotocycleTypes getType() {
        return type;
    }

    public void setType(MotocycleTypes type) {
        this.type = type;
    }
}
