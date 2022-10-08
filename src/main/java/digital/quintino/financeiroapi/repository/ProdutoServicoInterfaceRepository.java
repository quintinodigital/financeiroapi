package digital.quintino.financeiroapi.repository;

import digital.quintino.financeiroapi.domain.ProdutoServicoDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoServicoInterfaceRepository extends JpaRepository<ProdutoServicoDomain, Long> { }
