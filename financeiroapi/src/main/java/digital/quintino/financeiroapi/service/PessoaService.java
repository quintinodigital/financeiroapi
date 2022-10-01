package digital.quintino.financeiroapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.quintino.financeiroapi.domain.PessoaDomain;
import digital.quintino.financeiroapi.domain.TipoPessoaDomain;
import digital.quintino.financeiroapi.dto.PessoaResponseDTO;
import digital.quintino.financeiroapi.repository.PessoaInterfaceRepository;
import digital.quintino.financeiroapi.repository.TipoPessoaInterfaceRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaInterfaceRepository pessoaInterfaceRepository;
	
	@Autowired
	private TipoPessoaInterfaceRepository tipoPessoaInterfaceRepository;
	
	public PessoaResponseDTO saveOne(PessoaDomain pessoaDomain) {
		PessoaDomain pessoaDomainResultado = this.pessoaInterfaceRepository.save(pessoaDomain); 
		return this.converterParaDTO(pessoaDomainResultado);
	}
	
	public List<PessoaDomain> saveAll(List<PessoaDomain> pessoaDomainList) {
		return this.pessoaInterfaceRepository.saveAll(pessoaDomainList);
	}
	
	public List<PessoaResponseDTO> findAll() {
		List<PessoaDomain> pessoaDomainList = this.pessoaInterfaceRepository.findAll();
		List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
		for(PessoaDomain pessoaDomain : pessoaDomainList) {
			pessoaResponseDTOList.add(new PessoaResponseDTO(pessoaDomain.getCodigo(), pessoaDomain.getTipoPessoaDomain().getDescricao(), pessoaDomain.getNome()));
		}
		return pessoaResponseDTOList;
	}
	
	public PessoaResponseDTO findOne(Long codigo) {
		try {
			PessoaDomain pessoaDomain = this.pessoaInterfaceRepository.findById(codigo).get();
			if(pessoaDomain != null) {
				return new PessoaResponseDTO(pessoaDomain.getCodigo(), pessoaDomain.getTipoPessoaDomain().getDescricao(), pessoaDomain.getNome());
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public void deleteOne(Long codigo) {
		this.pessoaInterfaceRepository.delete(new PessoaDomain(codigo));
	}
	
	public PessoaResponseDTO updateOne(PessoaDomain pessoaDomain) {
		PessoaResponseDTO pessoaResponseDTOResultado = this.findOne(pessoaDomain.getCodigo());
			pessoaResponseDTOResultado.setNome(pessoaDomain.getNome());
			pessoaResponseDTOResultado.setCodigoTipoPessoa(pessoaDomain.getTipoPessoaDomain().getCodigo());
		return this.saveOne(this.converterParaEntidade(pessoaResponseDTOResultado));
	}
	
	private PessoaResponseDTO converterParaDTO(PessoaDomain pessoaDomain) {
		return new PessoaResponseDTO(pessoaDomain.getCodigo(), this.recuperarDescricaoTipoPessoa(pessoaDomain.getTipoPessoaDomain().getCodigo()), pessoaDomain.getNome());
	}
	
	private PessoaDomain converterParaEntidade(PessoaResponseDTO pessoaResponseDTO) {
		return new PessoaDomain(pessoaResponseDTO.getCodigo(), new TipoPessoaDomain(pessoaResponseDTO.getCodigoTipoPessoa()), pessoaResponseDTO.getNome());
	}
	
	private String recuperarDescricaoTipoPessoa(Long codigo) {
		return this.tipoPessoaInterfaceRepository.findById(codigo).get().getDescricao();
	}

}
