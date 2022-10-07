package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.TipoNegociacaoFinanceiraDomain;

public interface TipoNegociacaoFinanceiraRepository extends JpaRepository<TipoNegociacaoFinanceiraDomain, Long> { }
