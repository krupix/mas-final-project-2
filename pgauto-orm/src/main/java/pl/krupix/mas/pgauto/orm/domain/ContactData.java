package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.data.ContactDataDTO;

import javax.persistence.*;
import java.beans.*;

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


    public ContactData() {}

    public ContactData(ContactDataDTO dto)  {
        id = dto.getId();
        email = dto.getEmail();
        mobileNumber = dto.getMobileNumber();
        phoneNumber = dto.getPhoneNumber();
    }

    @java.beans.Transient
    public ContactDataDTO getDTO() {

        ContactDataDTO dto = new ContactDataDTO();

        dto.setId(id);
        dto.setEmail(email);
        dto.setMobileNumber(mobileNumber);
        dto.setPhoneNumber(phoneNumber);

        return dto;

    }

}
