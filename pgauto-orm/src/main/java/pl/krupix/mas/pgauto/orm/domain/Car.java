package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.vehicle.BodyTypes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "CAR")
@Data
public class Car extends Vehicle {

    @Column(name = "BODY_TYPE")
    private BodyTypes bodyType;

}
