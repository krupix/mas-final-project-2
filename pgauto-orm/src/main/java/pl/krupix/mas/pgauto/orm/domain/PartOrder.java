package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "ORDER_PART")
@Data
public class PartOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_PART_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="PART_ID", nullable = false)
    private Part part;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="ORDER_ID", nullable = false)
    private Order order;

}
