package pl.krupix.mas.pgauto.api.dto.person;

import pl.krupix.mas.pgauto.api.dto.garage.GarageEmployeeRepairDetailsDTO;
import pl.krupix.mas.pgauto.api.exception.IncorrectParameterException;
import pl.krupix.mas.pgauto.api.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
public class GarageEmployeeDTO extends EmployeeDTO {

    private static Integer MIN_HOURLY_PAY = 12;

    private List<GarageEmployeeRepairDetailsDTO> repairList = new ArrayList<GarageEmployeeRepairDetailsDTO>();


    public Integer calculateSalary(Date dateFrom, Date dateTo) {

        Integer totalHoursDiff = 0;

        for (GarageEmployeeRepairDetailsDTO repairDetail : repairList) {
            totalHoursDiff += DateUtil.getHoursDiff(repairDetail.getStartRepairDate(), repairDetail.getEndRepairDate());
        }

        return totalHoursDiff * getHourlyPay();
    }



    public void setHourlyPay(Integer hourlyPay) throws IncorrectParameterException {

        if (hourlyPay < MIN_HOURLY_PAY) {
            throw new IncorrectParameterException("hourly pay cannot be less than minimal hourly pay");
        } else {
            super.hourlyPay = hourlyPay;
        }
    }

    public List<GarageEmployeeRepairDetailsDTO> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<GarageEmployeeRepairDetailsDTO> repairList) {
        this.repairList = repairList;
    }

}
