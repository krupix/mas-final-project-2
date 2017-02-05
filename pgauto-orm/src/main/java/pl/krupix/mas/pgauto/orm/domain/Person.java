package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONS")
@Data
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="ADRESS_DATA_ID", nullable = false)
    private AdressData adressData;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="CONTACT_DATA_ID", nullable = false)
    private ContactData contactData;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "MAIDEN_NAME")
    private String maidenName;

    @Column(name = "PESEL")
    private String PESEL;
}
