package pl.krupix.mas.pgauto.dto.repair;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NonNull;
import pl.krupix.mas.pgauto.dto.data.AdressData;
import pl.krupix.mas.pgauto.dto.data.ContactData;

import java.util.List;
import java.util.Vector;

/**
 * Created by krupix on 01.02.2017.
 */
public class Warehouse {

    private AdressData adressData;

    private ContactData contactData;

    private String name;

    private Integer discount;

    private List<Part> parts;

}
