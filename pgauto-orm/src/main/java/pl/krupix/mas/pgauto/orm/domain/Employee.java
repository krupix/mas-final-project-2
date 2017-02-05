package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.person.ContractTypes;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "EMPLOYEES")
@Data
public abstract class Employee extends Person {

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @Column(name = "CONTRAT_TYPe")
    private ContractTypes contractType;

    @Column(name = "HOURLY_PAY")
    private Integer hourlyPay;


}
