package digital.quintino.financeiroapi.domain;

import java.io.Serializable;

public class ContaBancariaDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private InstituicaoFinanceiraDomain instituicaoFinanceiraDomain;
	
	private PessoaDomain pessoaTitular;
	
	private String numero;
	
	private String agencia;
	
	private Boolean isAtivo;
	
	public ContaBancariaDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public InstituicaoFinanceiraDomain getInstituicaoFinanceiraDomain() {
		return instituicaoFinanceiraDomain;
	}

	public void setInstituicaoFinanceiraDomain(InstituicaoFinanceiraDomain instituicaoFinanceiraDomain) {
		this.instituicaoFinanceiraDomain = instituicaoFinanceiraDomain;
	}

	public PessoaDomain getPessoaTitular() {
		return pessoaTitular;
	}

	public void setPessoaTitular(PessoaDomain pessoaTitular) {
		this.pessoaTitular = pessoaTitular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}
