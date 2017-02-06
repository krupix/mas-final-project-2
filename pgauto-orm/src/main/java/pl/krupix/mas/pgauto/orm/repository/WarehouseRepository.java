package pl.krupix.mas.pgauto.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krupix.mas.pgauto.api.dto.repair.WarehouseDTO;
import pl.krupix.mas.pgauto.orm.domain.Warehouse;

import java.util.List;

/**
 * Created by krupix on 05.02.2017.
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    List<Warehouse> findByName(String name);
}

