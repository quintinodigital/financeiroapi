package digital.quintino.financeiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.quintino.financeiroapi.domain.PessoaDomain;

public interface PessoaInterfaceRepository extends JpaRepository<PessoaDomain, Long> { }
