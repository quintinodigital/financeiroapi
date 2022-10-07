package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.ParcelaDomain;

public interface ParcelaInterfaceRepository extends JpaRepository<ParcelaDomain, Long> { }
