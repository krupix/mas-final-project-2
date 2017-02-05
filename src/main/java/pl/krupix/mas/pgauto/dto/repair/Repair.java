package pl.krupix.mas.pgauto.dto.repair;

import pl.krupix.mas.pgauto.dto.garage.GarageEmployeeRepairDetails;
import pl.krupix.mas.pgauto.dto.vehicle.VehicleRepairDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krupix on 03.02.2017.
 */
public class Repair {

    private static Integer repairIncomingsPercent = 10;

    private static Integer partsIncomingsPercent = 30;

    private Integer netPrice;

    private RepairTypes type;

    private RepairStatuses status;

    private List<GarageEmployeeRepairDetails> garageEmployeeRepairDetailsList = new ArrayList<GarageEmployeeRepairDetails>();

    private List<VehicleRepairDetails> vehicleRepairDetails = new ArrayList<VehicleRepairDetails>();

    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }

    public RepairTypes getType() {
        return type;
    }

    public void setType(RepairTypes type) {
        this.type = type;
    }

    public RepairStatuses getStatus() {
        return status;
    }

    public void setStatus(RepairStatuses status) {
        this.status = status;
    }

    public List<GarageEmployeeRepairDetails> getGarageEmployeeRepairDetailsList() {
        return garageEmployeeRepairDetailsList;
    }

    public void setGarageEmployeeRepairDetailsList(List<GarageEmployeeRepairDetails> garageEmployeeRepairDetailsList) {
        this.garageEmployeeRepairDetailsList = garageEmployeeRepairDetailsList;
    }

    public List<VehicleRepairDetails> getVehicleRepairDetails() {
        return vehicleRepairDetails;
    }

    public void setVehicleRepairDetails(List<VehicleRepairDetails> vehicleRepairDetails) {
        this.vehicleRepairDetails = vehicleRepairDetails;
    }
}
