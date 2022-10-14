package digital.quintino.financeiroapi.repository;

import digital.quintino.financeiroapi.domain.DespesaDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaInterfaceRepository extends JpaRepository<DespesaDomain, Long> { }
