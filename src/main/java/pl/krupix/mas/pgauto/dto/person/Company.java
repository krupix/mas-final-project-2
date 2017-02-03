package pl.krupix.mas.pgauto.dto.person;

import lombok.Data;
import pl.krupix.mas.pgauto.dto.data.AdressData;
import pl.krupix.mas.pgauto.dto.data.ContactData;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public abstract class Company {

    private AdressData adressData;

    private ContactData contactData;

    private String companyName;

    private String NIP;

}
