package pl.krupix.mas.pgauto.orm.domain;

import lombok.Data;
import pl.krupix.mas.pgauto.api.dto.repair.InvoiceDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by krupix on 05.02.2017.
 */
@Entity
@Table(name = "INVOICE")
@Data
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INVOICE_ID")
    private Long id;

    @Column(name = "NET_PRICE", nullable = false)
    private Integer netPrice;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "TITLE", nullable = false)
    private String title;

    public Invoice() {}

    public Invoice(InvoiceDTO dto) {
        id = dto.getId();
        netPrice = dto.getNetPrice();
        number = dto.getNumber();
        title = dto.getTitle();
        createDate = dto.getCreateDate();
    }


}
