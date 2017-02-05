package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "GARAGE_EMPLOYEE")
@Data
public abstract class GarageEmployee extends Employee {


}
