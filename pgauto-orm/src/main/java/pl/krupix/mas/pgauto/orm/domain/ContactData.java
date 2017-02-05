package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "CONTACT_DATA")
@Data
public class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_DATA_ID", nullable = false)
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

}
