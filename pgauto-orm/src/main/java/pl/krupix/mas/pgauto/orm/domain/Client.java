package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CLIENTS")
@Data
public class Client extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "COMPANY_NAME")
    private String comanyName;

    @Column(name = "NIP")
    private String NIP;


}
