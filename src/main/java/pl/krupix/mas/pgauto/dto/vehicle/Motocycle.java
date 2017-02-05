package pl.krupix.mas.pgauto.dto.vehicle;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import lombok.Data;
import pl.krupix.mas.pgauto.dto.person.Client;
import pl.krupix.mas.pgauto.exception.ParameterNotFoundException;

import java.util.Date;

/**
 * Created by krupix on 03.02.2017.
 */
public class Motocycle extends Vehicle {

    private MotocycleTypes type;


    public Motocycle(String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, MotocycleTypes type) {
        super(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN);
        this.type = type;
    }

    public static Motocycle createMotocycle(Client client, String manufacturer, String model, String registrationNumber, Integer engingeCapacity, Long mileage, String fuelType, Date productionDate, String VIN, MotocycleTypes type) throws ParameterNotFoundException {

        if (client == null) {
            throw new ParameterNotFoundException("client");
        }

        Motocycle motocycle = new Motocycle(manufacturer, model, registrationNumber, engingeCapacity, mileage, fuelType, productionDate, VIN, type);
        client.addMotocycle(motocycle);

        return motocycle;
    }


    public MotocycleTypes getType() {
        return type;
    }

    public void setType(MotocycleTypes type) {
        this.type = type;
    }
}
