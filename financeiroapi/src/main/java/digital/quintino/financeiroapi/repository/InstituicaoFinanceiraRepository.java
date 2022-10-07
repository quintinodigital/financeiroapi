package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.InstituicaoFinanceiraDomain;

public interface InstituicaoFinanceiraRepository extends JpaRepository<InstituicaoFinanceiraDomain, Long> { }
