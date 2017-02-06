package pl.krupix.mas.pgauto.api.dto.repair;

import pl.krupix.mas.pgauto.api.dto.data.AdressDataDTO;
import pl.krupix.mas.pgauto.api.dto.data.ContactDataDTO;

import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
public class WarehouseDTO {

    private Long id;

    private AdressDataDTO adressDataDTO;

    private ContactDataDTO contactDataDTO;

    private String name;

    private Integer discount;

    private List<PartDTO> partDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdressDataDTO getAdressDataDTO() {
        return adressDataDTO;
    }

    public void setAdressDataDTO(AdressDataDTO adressDataDTO) {
        this.adressDataDTO = adressDataDTO;
    }

    public ContactDataDTO getContactDataDTO() {
        return contactDataDTO;
    }

    public void setContactDataDTO(ContactDataDTO contactDataDTO) {
        this.contactDataDTO = contactDataDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public List<PartDTO> getPartDTOS() {
        return partDTOS;
    }

    public void setPartDTOS(List<PartDTO> partDTOS) {
        this.partDTOS = partDTOS;
    }
}
