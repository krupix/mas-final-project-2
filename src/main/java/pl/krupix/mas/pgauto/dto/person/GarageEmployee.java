package pl.krupix.mas.pgauto.dto.person;

import lombok.Data;
import pl.krupix.mas.pgauto.dto.garage.GarageEmployeeRepairDetails;
import pl.krupix.mas.pgauto.dto.repair.Repair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
public class GarageEmployee extends Employee {

    private static Integer MIN_HOURLY_PAY = 12;

    private List<GarageEmployeeRepairDetails> repairList = new ArrayList<GarageEmployeeRepairDetails>();


    public Integer calculateSalary(Date dateFrom, Date dateTo) {
        return null;
    }


    public List<GarageEmployeeRepairDetails> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<GarageEmployeeRepairDetails> repairList) {
        this.repairList = repairList;
    }
}
