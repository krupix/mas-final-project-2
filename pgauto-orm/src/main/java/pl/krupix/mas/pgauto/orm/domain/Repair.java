package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.repair.RepairStatuses;
import pl.krupix.mas.pgauto.api.dto.repair.RepairTypes;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "REPAIRS")
@Data
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "NET_PRICE")
    private Integer netPrice;

    @Column(name = "REPAIR_TYPE")
    private RepairTypes type;

    @Column(name = "REPAIR_STATUS")
    private RepairStatuses status;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

}
