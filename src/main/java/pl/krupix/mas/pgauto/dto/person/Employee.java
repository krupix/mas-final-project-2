package pl.krupix.mas.pgauto.dto.person;

import lombok.Data;

import java.util.Date;

/**
 * Created by krupix on 04.02.2017.
 */
@Data
public abstract class Employee extends Person {

    private static Integer salaryBonus;


    private Date hireDate;

    private ContractTypes contractType;

    private Integer hourlyPay;


    public abstract Integer calculateSalary(Date dateFrom, Date dateTo);


}
