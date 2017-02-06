package pl.krupix.mas.pgauto.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krupix.mas.pgauto.orm.domain.RepairVehicleDetails;

import java.util.Date;
import java.util.List;

/**
 * Created by krupix on 06.02.2017.
 */
public interface RepairVehicleDetailsRepository extends JpaRepository<RepairVehicleDetails, Long> {

    List<RepairVehicleDetails> findByStartDateBefore(Date currentDate);

}
