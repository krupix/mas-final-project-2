package pl.krupix.mas.pgauto.api.dto.vehicle;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import pl.krupix.mas.pgauto.api.dto.person.ClientDTO;
import pl.krupix.mas.pgauto.api.exception.ParameterNotFoundException;

import java.util.Date;

/**
 * Created by krupix on 03.02.2017.
 */
public class CarDTO extends VehicleDTO {

    private BodyTypes bodyType;

    public CarDTO(String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, BodyTypes bodyType) {
        super(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN);
        this.bodyType = bodyType;
    }



    public static CarDTO createCar(ClientDTO clientDTO, String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, BodyTypes bodyType) throws ParameterNotFoundException {

        if (clientDTO == null) {
            throw new ParameterNotFoundException("clientDTO");
        }

        CarDTO carDTO = new CarDTO(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN, bodyType);
        clientDTO.addCar(carDTO);

        return carDTO;
    }


    public BodyTypes getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyTypes bodyType) {
        this.bodyType = bodyType;
    }
}

