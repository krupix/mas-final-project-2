package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "GARAGES")
@Data
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GARAGE_ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="ADRESS_DATA_ID", nullable = false)
    private AdressData adressData;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="CONTACT_DATA_ID", nullable = false)
    private ContactData contactData;

    @Column(name = "NAME", nullable = false)
    private String name;

}
