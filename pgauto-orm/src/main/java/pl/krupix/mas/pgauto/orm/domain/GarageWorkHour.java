package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.garage.Days;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "GARAGE_WORK_HOURS")
@Data
public class GarageWorkHour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GARAGE_WORK_HOUR_ID")
    private Long id;

    @Column(name = "DAY")
    private Days day;

    @Column(name = "OPEN_HOUR")
    private Integer openHour;

    @Column(name = "CLOSE_HOUR")
    private Integer closeHour;

    @ManyToOne
    @JoinColumn(name = "GARAGE_ID")
    private Garage garage;

}
