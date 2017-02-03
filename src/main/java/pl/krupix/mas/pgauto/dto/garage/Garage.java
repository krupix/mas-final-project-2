package pl.krupix.mas.pgauto.dto.garage;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import pl.krupix.mas.pgauto.dto.data.AdressData;
import pl.krupix.mas.pgauto.dto.data.ContactData;
import pl.krupix.mas.pgauto.dto.person.Employee;

import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public class Garage {

    private ContactData contactData;

    private AdressData adressData;

    private String garageName;

    @NotNull
    private List<GarageWorkHour> garageWorkHours;

    @NotNull
    private List<Employee> employees;


}
