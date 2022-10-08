package digital.quintino.financeiroapi.repository;

import digital.quintino.financeiroapi.domain.CartaoBancarioDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoBancarioInterfaceRepository extends JpaRepository<CartaoBancarioDomain, Long> { }
