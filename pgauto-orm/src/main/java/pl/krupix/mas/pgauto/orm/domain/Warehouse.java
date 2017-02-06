package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.repair.WarehouseDTO;

import javax.persistence.*;
import java.beans.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "WAREHOUSES")
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WAREHOUSE_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="ADRESS_DATA_ID")
    private AdressData adressData;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="CONTACT_DATA_ID")
    private ContactData contactData;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DISCOUNT")
    private Integer discount;


    public Warehouse() {}

    public Warehouse(WarehouseDTO dto) {
        id = dto.getId();
        adressData = new AdressData(dto.getAdressDataDTO());
        contactData = new ContactData(dto.getContactDataDTO());
        name = dto.getName();
        discount = dto.getDiscount();
    }

    @java.beans.Transient
    public WarehouseDTO getDTO() {

        WarehouseDTO dto = new WarehouseDTO();

        dto.setId(id);

        if (adressData != null) {
            dto.setAdressDataDTO(adressData.getDTO());
        }

        if (contactData != null) {
            dto.setContactDataDTO(contactData.getDTO());
        }

        dto.setName(name);
        dto.setDiscount(discount);

        return dto;

    }

}
