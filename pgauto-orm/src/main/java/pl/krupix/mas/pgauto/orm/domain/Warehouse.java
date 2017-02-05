package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "WAREHOUSES")
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WAREHOUSE_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="ADRESS_DATA_ID")
    private AdressData adressData;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="CONTACT_DATA_ID")
    private ContactData contactData;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISCOUNT")
    private Integer discount;

}
