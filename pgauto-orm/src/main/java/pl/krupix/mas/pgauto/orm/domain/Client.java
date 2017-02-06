package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.person.ClientDTO;

import javax.persistence.*;
import java.beans.*;

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

    @java.beans.Transient
    public ClientDTO getDTO() {

        ClientDTO dto = new ClientDTO();

        dto.setId(id);
        dto.setComanyName(comanyName);
        dto.setName(getName());
        dto.setSurname(getSurname());
        dto.setNIP(getNIP());
        dto.setMaidenName(getMaidenName());
        dto.setAdressDataDTO(getAdressData().getDTO());
        dto.setContactDataDTO(getContactData().getDTO());
        dto.setPESEL(getPESEL());

        return dto;
    }


}
