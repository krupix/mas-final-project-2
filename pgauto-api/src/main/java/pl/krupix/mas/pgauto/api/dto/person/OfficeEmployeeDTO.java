package pl.krupix.mas.pgauto.api.dto.person;

import lombok.Data;
import pl.krupix.mas.pgauto.api.exception.IncorrectDateException;
import pl.krupix.mas.pgauto.api.exception.IncorrectParameterException;
import pl.krupix.mas.pgauto.api.util.DateUtil;

import java.util.Date;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public class OfficeEmployeeDTO extends EmployeeDTO {

    private static Integer MIN_HOURLY_PAY = 13;

    public Integer calculateSalary(Date dateFrom, Date dateTo) throws IncorrectDateException {

        Integer daysDiff = DateUtil.calculateDaysDiff(dateFrom, dateTo);

        if (daysDiff < 0) {
            throw new IncorrectDateException("days diff cannot be less than 0");
        }

        return daysDiff * getHourlyPay() * 8;
    }

    public void setHourlyPay(Integer hourlyPay) throws IncorrectParameterException {

        if (hourlyPay < MIN_HOURLY_PAY) {
            throw new IncorrectParameterException("hourly pay cannot be less than minimal hourly pay");
        } else {
            super.hourlyPay = hourlyPay;
        }
    }
}
