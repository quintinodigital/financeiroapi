package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.TipoAcessoDomain;

public interface TipoAcessoInterfaceRepository extends JpaRepository<TipoAcessoDomain, Long> { }
