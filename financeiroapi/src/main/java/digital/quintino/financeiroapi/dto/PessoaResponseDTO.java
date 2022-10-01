package digital.quintino.financeiroapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PessoaResponseDTO {
	
	private Long codigo;
	
	private String nome;
	
	@JsonIgnore
	private Long codigoTipoPessoa;
	
	private String descricaoTipoPessoa;
	
	public PessoaResponseDTO() { }

	public PessoaResponseDTO(Long codigo, String descricaoTipoPessoa, String nome) {
		this.codigo = codigo;
		this.descricaoTipoPessoa = descricaoTipoPessoa;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoTipoPessoa() {
		return descricaoTipoPessoa;
	}

	public void setDescricaoTipoPessoa(String descricaoTipoPessoa) {
		this.descricaoTipoPessoa = descricaoTipoPessoa;
	}

	public Long getCodigoTipoPessoa() {
		return codigoTipoPessoa;
	}

	public void setCodigoTipoPessoa(Long codigoTipoPessoa) {
		this.codigoTipoPessoa = codigoTipoPessoa;
	}

}
