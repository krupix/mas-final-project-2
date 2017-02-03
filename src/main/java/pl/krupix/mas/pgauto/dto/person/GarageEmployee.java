package pl.krupix.mas.pgauto.dto.person;

import lombok.Data;

import java.util.Date;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public class GarageEmployee extends Employee {

    private static Integer MIN_HOURLY_PAY = 12;


    public Integer calculateSalary(Date dateFrom, Date dateTo) {
        return null;
    }
}
