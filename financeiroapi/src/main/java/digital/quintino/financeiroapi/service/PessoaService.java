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
	
	public PessoaDomain saveOne(PessoaDomain pessoaDomain) {
		return this.pessoaInterfaceRepository.save(pessoaDomain);
	}
	
	public List<PessoaDomain> saveAll(List<PessoaDomain> pessoaDomainList) {
		return this.pessoaInterfaceRepository.saveAll(pessoaDomainList);
	}
	
	public List<PessoaDomain> findAll() {
		return this.pessoaInterfaceRepository.findAll();
	}
	
	public PessoaDomain findOne(Long codigo) {
		try {
			PessoaDomain pessoaDomain = this.pessoaInterfaceRepository.findById(codigo).get();
			if(pessoaDomain != null) {
				return pessoaDomain;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public void deleteOne(Long codigo) {
		this.pessoaInterfaceRepository.delete(this.findOne(codigo));
	}
	
	public PessoaDomain updateOne(PessoaDomain pessoaDomain) {
		PessoaDomain pessoaDomainResultado = this.findOne(pessoaDomain.getCodigo());
			pessoaDomainResultado.setNome(pessoaDomain.getNome());
			pessoaDomainResultado.setTipoPessoaDomain(pessoaDomain.getTipoPessoaDomain());
		return this.saveOne(pessoaDomainResultado);
	}

}
