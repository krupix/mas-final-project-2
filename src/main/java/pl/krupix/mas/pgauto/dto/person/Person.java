package pl.krupix.mas.pgauto.dto.person;

import lombok.Data;
import pl.krupix.mas.pgauto.dto.data.AdressData;
import pl.krupix.mas.pgauto.dto.data.ContactData;

import java.util.Date;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public abstract class Person {

    private ContactData contactData;

    private AdressData adressData;

    private Date birthDate;

    private String name;

    private String surname;

    private String maidenName;

    private String PESEL;

    private Integer age;

}
