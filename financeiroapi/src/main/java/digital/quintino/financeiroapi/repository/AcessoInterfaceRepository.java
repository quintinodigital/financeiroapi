package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.AcessoDomain;

public interface AcessoInterfaceRepository extends JpaRepository<AcessoDomain, Long> { }
