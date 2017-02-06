package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.repair.PartDTO;

import javax.persistence.*;
import java.beans.*;
import java.util.List;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "PARTS")
@Data
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PART_ID")
    private Long id;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "NET_PRICE")
    private Integer netPrice;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "WAREHOUSE_ID")
    private Warehouse warehouse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "part")
    private List<PartElement> includedElements;


    public Part() {}

    public Part(PartDTO dto) {
        id = dto.getId();
        manufacturer = dto.getManufacturer();
        netPrice = dto.getNetPrice();

        if (dto.getWarehouseDTO() != null) {
            warehouse = new Warehouse(dto.getWarehouseDTO());
        }
    }

    @java.beans.Transient
    public PartDTO getDTO() {

        PartDTO dto = new PartDTO();

        dto.setId(id);
        dto.setManufacturer(manufacturer);
        dto.setNetPrice(netPrice);

        return dto;
    }


}
