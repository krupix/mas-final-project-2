package pl.krupix.mas.pgauto.dto.data;

import lombok.Data;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public class AdressData {

    private String zipCode;

    private String city;

    private Integer houseNumber;

    private Integer flatNumber;

    private String street;

}
