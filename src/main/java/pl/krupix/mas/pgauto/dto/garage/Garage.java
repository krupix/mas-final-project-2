package pl.krupix.mas.pgauto.dto.garage;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NonNull;
import pl.krupix.mas.pgauto.dto.data.AdressData;
import pl.krupix.mas.pgauto.dto.data.ContactData;
import pl.krupix.mas.pgauto.dto.person.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
public class Garage {

    private ContactData contactData;

    private AdressData adressData;

    private String garageName;

    private List<GarageWorkHour> garageWorkHours = new ArrayList<GarageWorkHour>();

    private List<Employee> employees = new ArrayList<Employee>();


    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public AdressData getAdressData() {
        return adressData;
    }

    public void setAdressData(AdressData adressData) {
        this.adressData = adressData;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public List<GarageWorkHour> getGarageWorkHours() {
        return garageWorkHours;
    }

    public void setGarageWorkHours(List<GarageWorkHour> garageWorkHours) {
        this.garageWorkHours = garageWorkHours;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
