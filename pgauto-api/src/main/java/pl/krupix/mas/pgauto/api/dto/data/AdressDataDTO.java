package pl.krupix.mas.pgauto.api.dto.data;

import lombok.Data;

/**
 * Created by krupix on 01.02.2017.
 */
@Data
public class AdressDataDTO {

    private Long id;

    private String zipCode;

    private String city;

    private Integer houseNumber;

    private Integer flatNumber;

    private String street;

}
