package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "ADRESS_DATA")
@Data
public class AdressData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADRESS_DATA_ID", nullable = false)
    private Long id;

    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "HOUSE_NUMBER", nullable = false)
    private Integer houseNumber;

    @Column(name = "FLAT_NUMBER")
    private Integer flatNumber;

    @Column(name = "STREET", nullable = false)
    private String street;

}
