package pl.krupix.mas.pgauto.dto.garage;

import pl.krupix.mas.pgauto.dto.person.GarageEmployee;
import pl.krupix.mas.pgauto.dto.repair.Repair;

import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
public class GarageEmployeeRepairDetails {

    private GarageEmployee garageEmployee;

    private Repair repair;

    private Date startRepairDate;

    private Date endRepairDate;


    public GarageEmployee getGarageEmployee() {
        return garageEmployee;
    }

    public void setGarageEmployee(GarageEmployee garageEmployee) {
        this.garageEmployee = garageEmployee;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
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
