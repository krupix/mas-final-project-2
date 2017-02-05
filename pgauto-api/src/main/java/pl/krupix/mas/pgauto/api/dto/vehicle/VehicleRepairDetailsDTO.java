package pl.krupix.mas.pgauto.api.dto.vehicle;

import pl.krupix.mas.pgauto.api.dto.repair.RepairDTO;

/**
 * Created by krupix on 05.02.2017.
 */
public class VehicleRepairDetailsDTO {

    private VehicleDTO vehicleDTO;

    private RepairDTO repairDTO;

    private String description;


    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }

    public RepairDTO getRepairDTO() {
        return repairDTO;
    }

    public void setRepairDTO(RepairDTO repairDTO) {
        this.repairDTO = repairDTO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
