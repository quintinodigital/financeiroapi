package digital.quintino.financeiroapi.domain;

import java.io.Serializable;

public class CartaoBancarioDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private ContaBancariaDomain contaBancariaDomain;
	
	private String numero;
	
	private String mesAnoValidade;
	
	private Boolean isAtivo;
	
	public CartaoBancarioDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public ContaBancariaDomain getContaBancariaDomain() {
		return contaBancariaDomain;
	}

	public void setContaBancariaDomain(ContaBancariaDomain contaBancariaDomain) {
		this.contaBancariaDomain = contaBancariaDomain;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMesAnoValidade() {
		return mesAnoValidade;
	}

	public void setMesAnoValidade(String mesAnoValidade) {
		this.mesAnoValidade = mesAnoValidade;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}
