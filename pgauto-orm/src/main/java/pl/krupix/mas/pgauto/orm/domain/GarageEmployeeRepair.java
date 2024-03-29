package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "GARAGE_EMPLOYEE_REPAIR")
@Data
public class GarageEmployeeRepair {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "GARAGE_EMPLOYEE_ID", nullable = false)
    private GarageEmployee garageEmployee;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "REPAIR_ID", nullable = false)
    private Repair repair;

    @Column(name = "START_DATE", nullable = false)
    private Date startRepairDate;

    @Column(name = "END_DATE")
    private Date endRepairDate;

}
