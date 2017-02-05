package pl.krupix.mas.pgauto.dto.person;

import com.sun.istack.internal.NotNull;
import com.sun.jdi.ObjectCollectedException;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import lombok.Data;
import lombok.NonNull;
import pl.krupix.mas.pgauto.dto.vehicle.Car;
import pl.krupix.mas.pgauto.dto.vehicle.Motocycle;
import pl.krupix.mas.pgauto.dto.vehicle.Vehicle;
import pl.krupix.mas.pgauto.dto.vehicle.VehicleRepairDetails;

import java.util.Date;
import java.util.HashSet;
import java.util.Vector;

/**
 * Created by krupix on 04.02.2017.
 */
public class Client  {

    private static HashSet<Vehicle> allVehicles = new HashSet<Vehicle>();

    private Vector<Vehicle> vehicles = new Vector<Vehicle>();

    public Integer getRegularCustomerDiscount() {

        Integer repairsCount = 0;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleRepairDetailsList() != null) {
                repairsCount += vehicle.getVehicleRepairDetailsList().size();
            }

        }

        if (repairsCount > 15) {
            return 10;
        } else if (repairsCount > 5) {
            return 5;
        } else {
            return 0;
        }

    }


    public void addCar(Car car) {

        if (!vehicles.contains(car)) {

            if (allVehicles.contains(car)) {
                throw new ObjectCollectedException("Car are already added to other client: " + car);
            }

            vehicles.add(car);
            allVehicles.add(car);
        }

    }

    public void addMotocycle(Motocycle motocycle) {

        if (!vehicles.contains(motocycle)) {

            if (allVehicles.contains(motocycle)) {
                throw new ObjectCollectedException("Motocycle are already added to other client: " + motocycle);
            }

            vehicles.add(motocycle);
            allVehicles.add(motocycle);
        }

    }

}
