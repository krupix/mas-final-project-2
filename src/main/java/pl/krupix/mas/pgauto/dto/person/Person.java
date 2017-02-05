package pl.krupix.mas.pgauto.dto.person;

import lombok.Getter;
import lombok.Setter;
import pl.krupix.mas.pgauto.util.PeselUtil;
import pl.krupix.mas.pgauto.dto.data.AdressData;
import pl.krupix.mas.pgauto.dto.data.ContactData;
import pl.krupix.mas.pgauto.exception.PeselNotFoundException;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by krupix on 01.02.2017.
 */

public abstract class Person {

    @Getter @Setter private ContactData contactData;

    @Getter @Setter private AdressData adressData;

    @Getter @Setter private String name;

    @Getter @Setter private String surname;

    @Getter @Setter private String maidenName;

    @Setter private String PESEL;


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


}
