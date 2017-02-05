package pl.krupix.mas.pgauto.api.dto.person;

import pl.krupix.mas.pgauto.api.exception.IncorrectDateException;
import pl.krupix.mas.pgauto.api.exception.IncorrectParameterException;

import java.util.Date;

/**
 * Created by krupix on 04.02.2017.
 */
public abstract class EmployeeDTO extends PersonDTO {

    private static Integer salaryBonus;


    private Date hireDate;

    private ContractTypes contractType;

    protected Integer hourlyPay;


    public abstract Integer calculateSalary(Date dateFrom, Date dateTo) throws IncorrectDateException;


    public static Integer getSalaryBonus() {
        return salaryBonus;
    }

    public static void setSalaryBonus(Integer salaryBonus) {
        EmployeeDTO.salaryBonus = salaryBonus;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public ContractTypes getContractType() {
        return contractType;
    }

    public void setContractType(ContractTypes contractType) {
        this.contractType = contractType;
    }

    public Integer getHourlyPay() {
        return hourlyPay;
    }

    public abstract void setHourlyPay(Integer hourlyPay) throws IncorrectParameterException;

}
