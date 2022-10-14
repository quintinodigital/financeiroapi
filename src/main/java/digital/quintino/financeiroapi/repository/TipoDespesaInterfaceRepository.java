package digital.quintino.financeiroapi.repository;

import digital.quintino.financeiroapi.domain.TipoDespesaDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDespesaInterfaceRepository extends JpaRepository<TipoDespesaDomain, Long> { }
