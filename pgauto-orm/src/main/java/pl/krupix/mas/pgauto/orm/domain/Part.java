package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;
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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "WAREHOUSE_ID")
    private Warehouse warehouse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "part")
    private List<PartElement> includedElements;

}
