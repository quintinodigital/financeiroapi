package digital.quintino.financeiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.quintino.financeiroapi.domain.AcessoDomain;
import digital.quintino.financeiroapi.repository.AcessoInterfaceRepository;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoInterfaceRepository acessoInterfaceRepository;
	
	public AcessoDomain save(AcessoDomain acessoDomain) {
		return this.acessoInterfaceRepository.save(acessoDomain);
	}
	
	public List<AcessoDomain> saveAll(List<AcessoDomain> acessoDomainList) {
		return this.acessoInterfaceRepository.saveAll(acessoDomainList);
	}

}
