package pl.krupix.mas.pgauto.api.dto.garage;

import pl.krupix.mas.pgauto.api.dto.person.EmployeeDTO;
import pl.krupix.mas.pgauto.api.dto.data.AdressDataDTO;
import pl.krupix.mas.pgauto.api.dto.data.ContactDataDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
public class GarageDTO {

    private ContactDataDTO contactDataDTO;

    private AdressDataDTO adressDataDTO;

    private String garageName;

    private List<GarageWorkHourDTO> garageWorkHourDTOS = new ArrayList<GarageWorkHourDTO>();

    private List<EmployeeDTO> employeeDTOS = new ArrayList<EmployeeDTO>();


    public ContactDataDTO getContactDataDTO() {
        return contactDataDTO;
    }

    public void setContactDataDTO(ContactDataDTO contactDataDTO) {
        this.contactDataDTO = contactDataDTO;
    }

    public AdressDataDTO getAdressData() {
        return adressDataDTO;
    }

    public void setAdressData(AdressDataDTO adressDataDTO) {
        this.adressDataDTO = adressDataDTO;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public List<GarageWorkHourDTO> getGarageWorkHourDTOS() {
        return garageWorkHourDTOS;
    }

    public void setGarageWorkHourDTOS(List<GarageWorkHourDTO> garageWorkHourDTOS) {
        this.garageWorkHourDTOS = garageWorkHourDTOS;
    }

    public List<EmployeeDTO> getEmployeeDTOS() {
        return employeeDTOS;
    }

    public void setEmployeeDTOS(List<EmployeeDTO> employeeDTOS) {
        this.employeeDTOS = employeeDTOS;
    }
}
