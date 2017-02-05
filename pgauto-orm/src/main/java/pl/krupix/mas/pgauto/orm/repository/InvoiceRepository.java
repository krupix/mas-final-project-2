package pl.krupix.mas.pgauto.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import pl.krupix.mas.pgauto.orm.domain.Invoice;

/**
 * Created by krupix on 05.02.2017.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
