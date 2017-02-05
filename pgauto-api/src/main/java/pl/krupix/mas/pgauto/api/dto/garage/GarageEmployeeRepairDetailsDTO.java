package pl.krupix.mas.pgauto.api.dto.garage;

import pl.krupix.mas.pgauto.api.dto.repair.RepairDTO;
import pl.krupix.mas.pgauto.api.dto.person.GarageEmployeeDTO;

import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
public class GarageEmployeeRepairDetailsDTO {

    private GarageEmployeeDTO garageEmployee;

    private RepairDTO repairDTO;

    private Date startRepairDate;

    private Date endRepairDate;


    public GarageEmployeeDTO getGarageEmployee() {
        return garageEmployee;
    }

    public void setGarageEmployee(GarageEmployeeDTO garageEmployee) {
        this.garageEmployee = garageEmployee;
    }

    public RepairDTO getRepairDTO() {
        return repairDTO;
    }

    public void setRepairDTO(RepairDTO repairDTO) {
        this.repairDTO = repairDTO;
    }

    public Date getStartRepairDate() {
        return startRepairDate;
    }

    public void setStartRepairDate(Date startRepairDate) {
        this.startRepairDate = startRepairDate;
    }

    public Date getEndRepairDate() {
        return endRepairDate;
    }

    public void setEndRepairDate(Date endRepairDate) {
        this.endRepairDate = endRepairDate;
    }
}
