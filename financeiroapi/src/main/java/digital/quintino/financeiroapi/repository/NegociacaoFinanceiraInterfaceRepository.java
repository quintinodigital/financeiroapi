package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraDomain;

public interface NegociacaoFinanceiraInterfaceRepository extends JpaRepository<NegociacaoFinanceiraDomain, Long> { }
