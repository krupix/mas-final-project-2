package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.vehicle.MotocycleTypes;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MOTOCYCLE")
@Data
public class Motocycle extends Vehicle {

    @Column(name = "MOTOCYCLE_TYPE")
    private MotocycleTypes motocycleType;


}
