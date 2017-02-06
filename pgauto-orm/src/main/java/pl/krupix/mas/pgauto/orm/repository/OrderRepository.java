package pl.krupix.mas.pgauto.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krupix.mas.pgauto.orm.domain.Order;

/**
 * Created by krupix on 06.02.2017.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
