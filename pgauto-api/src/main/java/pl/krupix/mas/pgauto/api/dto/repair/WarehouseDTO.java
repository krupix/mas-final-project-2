package pl.krupix.mas.pgauto.api.dto.repair;

import pl.krupix.mas.pgauto.api.dto.data.AdressDataDTO;
import pl.krupix.mas.pgauto.api.dto.data.ContactDataDTO;

import java.util.List;

/**
 * Created by krupix on 01.02.2017.
 */
public class WarehouseDTO {

    private AdressDataDTO adressDataDTO;

    private ContactDataDTO contactDataDTO;

    private String name;

    private Integer discount;

    private List<PartDTO> partDTOS;

}
