package digital.quintino.financeiroapi.domain;

import java.io.Serializable;

public class FaturaBancariaDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private CartaoBancarioDomain cartaoBancarioDomain;
	
	private String identificador;
	
	private Double valorTotal;
	
	private Integer diaFechamento;
	
	private Integer diaPagamento;
	
	public FaturaBancariaDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CartaoBancarioDomain getCartaoBancarioDomain() {
		return cartaoBancarioDomain;
	}

	public void setCartaoBancarioDomain(CartaoBancarioDomain cartaoBancarioDomain) {
		this.cartaoBancarioDomain = cartaoBancarioDomain;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getDiaFechamento() {
		return diaFechamento;
	}

	public void setDiaFechamento(Integer diaFechamento) {
		this.diaFechamento = diaFechamento;
	}

	public Integer getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(Integer diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

}
