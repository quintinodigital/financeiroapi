package digital.quintino.financeiroapi.repository;

import digital.quintino.financeiroapi.domain.ContaBancariaDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaInterfaceRepository extends JpaRepository<ContaBancariaDomain, Long> { }
