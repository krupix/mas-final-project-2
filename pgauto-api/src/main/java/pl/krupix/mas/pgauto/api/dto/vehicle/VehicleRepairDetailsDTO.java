package pl.krupix.mas.pgauto.api.dto.vehicle;

import pl.krupix.mas.pgauto.api.dto.repair.RepairDTO;

import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
public class VehicleRepairDetailsDTO {

    private Long id;

    private VehicleDTO vehicleDTO;

    private RepairDTO repairDTO;

    private Date startDate;

    private Date endDate;

    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
