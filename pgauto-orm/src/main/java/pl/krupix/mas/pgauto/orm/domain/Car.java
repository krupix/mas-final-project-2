package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.person.ClientDTO;
import pl.krupix.mas.pgauto.api.dto.vehicle.BodyTypes;
import pl.krupix.mas.pgauto.api.dto.vehicle.CarDTO;


import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CAR")
@Data
public class Car extends Vehicle {

    @Column(name = "BODY_TYPE")
    private BodyTypes bodyType;


}
