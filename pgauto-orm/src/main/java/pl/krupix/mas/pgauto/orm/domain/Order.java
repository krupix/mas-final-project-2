package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "ORDERS")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "GARAGE_EMPLOYEE_ID", nullable = false)
    private Part part;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "REPAIR_ID", nullable = false)
    private Repair repair;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;

    @Column(name = "NET_PRICE")
    private Integer netPrice;

}
