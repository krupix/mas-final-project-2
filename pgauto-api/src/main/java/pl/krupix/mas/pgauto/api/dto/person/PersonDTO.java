package pl.krupix.mas.pgauto.api.dto.person;

import pl.krupix.mas.pgauto.api.exception.PeselNotFoundException;
import pl.krupix.mas.pgauto.api.util.PeselUtil;
import pl.krupix.mas.pgauto.api.dto.data.AdressDataDTO;
import pl.krupix.mas.pgauto.api.dto.data.ContactDataDTO;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by krupix on 01.02.2017.
 */

public abstract class PersonDTO {

    private ContactDataDTO contactDataDTO;

    private AdressDataDTO adressDataDTO;

    private String name;

    private String surname;

    private String maidenName;

    private String PESEL;


    public String getPESEL() throws PeselNotFoundException {

        if (PESEL != null) {
            return PESEL;
        } else {
            throw new PeselNotFoundException();
        }

    }

    public Date getBirthDate() throws PeselNotFoundException, ParseException {

        if (PESEL != null) {
            return PeselUtil.getBirthDate(PESEL);
        } else {
            throw new PeselNotFoundException();
        }

    }

    public Integer getAge() throws PeselNotFoundException, ParseException {

        if (PESEL != null) {
            return PeselUtil.getAge(PESEL);
        } else {
            throw new PeselNotFoundException();
        }

    }

    public ContactDataDTO getContactDataDTO() {
        return contactDataDTO;
    }

    public void setContactDataDTO(ContactDataDTO contactDataDTO) {
        this.contactDataDTO = contactDataDTO;
    }

    public AdressDataDTO getAdressDataDTO() {
        return adressDataDTO;
    }

    public void setAdressDataDTO(AdressDataDTO adressDataDTO) {
        this.adressDataDTO = adressDataDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
}
