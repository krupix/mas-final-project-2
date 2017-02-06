package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.data.AdressDataDTO;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "ADRESS_DATA")
@Data
public class AdressData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADRESS_DATA_ID", nullable = false)
    private Long id;

    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "HOUSE_NUMBER", nullable = false)
    private Integer houseNumber;

    @Column(name = "FLAT_NUMBER")
    private Integer flatNumber;

    @Column(name = "STREET", nullable = false)
    private String street;


    public AdressData() {}

    public AdressData(AdressDataDTO dto) {
        id = dto.getId();
        zipCode = dto.getZipCode();
        city = dto.getCity();
        houseNumber = dto.getHouseNumber();
        flatNumber = dto.getFlatNumber();
        street = dto.getStreet();
    }



    public AdressDataDTO getDTO() {

        AdressDataDTO dto = new AdressDataDTO();

        dto.setId(id);
        dto.setZipCode(zipCode);
        dto.setCity(city);
        dto.setFlatNumber(flatNumber);
        dto.setHouseNumber(houseNumber);
        dto.setStreet(street);

        return dto;

    }


}
