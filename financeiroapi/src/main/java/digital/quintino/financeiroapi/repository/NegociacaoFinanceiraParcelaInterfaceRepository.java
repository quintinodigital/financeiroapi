package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraParcelaDomain;

public interface NegociacaoFinanceiraParcelaInterfaceRepository extends JpaRepository<NegociacaoFinanceiraParcelaDomain, Long> { }
