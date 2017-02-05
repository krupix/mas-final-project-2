package pl.krupix.mas.pgauto.dto.vehicle;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import lombok.Data;
import pl.krupix.mas.pgauto.dto.person.Client;
import pl.krupix.mas.pgauto.exception.ParameterNotFoundException;

import java.util.Date;

/**
 * Created by krupix on 03.02.2017.
 */
public class Car extends Vehicle {

    private BodyType bodyType;

    public Car(String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, BodyType bodyType) {
        super(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN);
        this.bodyType = bodyType;
    }



    public static Car createCar(Client client, String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, BodyType bodyType) throws ParameterNotFoundException {

        if (client == null) {
            throw new ParameterNotFoundException("client");
        }

        Car car = new Car(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN, bodyType);
        client.addCar(car);

        return car;
    }


    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}

