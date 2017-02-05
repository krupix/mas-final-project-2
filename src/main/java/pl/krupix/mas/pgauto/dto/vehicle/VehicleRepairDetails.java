package pl.krupix.mas.pgauto.dto.vehicle;

import pl.krupix.mas.pgauto.dto.repair.Repair;

/**
 * Created by krupix on 05.02.2017.
 */
public class VehicleRepairDetails {

    private Vehicle vehicle;

    private Repair repair;

    private String description;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
