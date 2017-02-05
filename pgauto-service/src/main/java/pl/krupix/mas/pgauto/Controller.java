package pl.krupix.mas.pgauto;


import org.apache.log4j.Logger;
import pl.krupix.mas.pgauto.orm.domain.Invoice;
import pl.krupix.mas.pgauto.orm.repository.InvoiceRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by krupix on 05.02.2017.
 */
public class Controller {

    private static transient Logger logger = Logger.getLogger(Controller.class);

    @Inject
    private InvoiceRepository invoiceRepository;

    public void repoTest() {


        logger.info("getting invoice list from repo: " + invoiceRepository);
        List<Invoice> invoiceList = invoiceRepository.findAll();
        logger.info("GOT IT!: " + invoiceRepository);


    }



}
