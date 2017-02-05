package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MECHANIC")
@Data
public class Mechanic extends GarageEmployee {
}
