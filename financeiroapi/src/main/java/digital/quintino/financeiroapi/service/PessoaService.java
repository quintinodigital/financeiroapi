package digital.quintino.financeiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.quintino.financeiroapi.domain.PessoaDomain;
import digital.quintino.financeiroapi.repository.PessoaInterfaceRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaInterfaceRepository pessoaInterfaceRepository;
	
	public PessoaDomain save(PessoaDomain pessoaDomain) {
		return this.pessoaInterfaceRepository.save(pessoaDomain);
	}
	
	public List<PessoaDomain> saveAll(List<PessoaDomain> pessoaDomainList) {
		return this.pessoaInterfaceRepository.saveAll(pessoaDomainList);
	}

}
