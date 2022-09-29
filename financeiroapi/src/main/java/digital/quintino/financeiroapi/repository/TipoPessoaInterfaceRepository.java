package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.TipoPessoaDomain;

public interface TipoPessoaInterfaceRepository extends JpaRepository<TipoPessoaDomain, Long> { }
