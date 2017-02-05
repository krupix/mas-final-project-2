package pl.krupix.mas.pgauto.orm.dao.impl;

import org.apache.log4j.Logger;
import pl.krupix.mas.pgauto.orm.dao.DaoService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by krupix on 05.02.2017.
 */
public class DaoServiceImpl implements DaoService {

    @PersistenceContext(unitName = "pgAutoUnit")
    EntityManager entityManager;
    protected Logger logger = Logger.getLogger(DaoServiceImpl.class);

}
