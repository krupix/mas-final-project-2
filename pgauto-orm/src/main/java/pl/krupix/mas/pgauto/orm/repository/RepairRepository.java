package pl.krupix.mas.pgauto.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krupix.mas.pgauto.orm.domain.Repair;

/**
 * Created by krupix on 06.02.2017.
 */
public interface RepairRepository extends JpaRepository<Repair, Long> {
}
