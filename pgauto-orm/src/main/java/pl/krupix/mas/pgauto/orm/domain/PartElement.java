package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "PART_ELEMENT")
@Data
public class PartElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PART_ELEMENT_ID")
    private Long id;

    @Column(name = "ELEMENT_NAME")
    private String elementName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "PART_ID")
    private Part part;

}
