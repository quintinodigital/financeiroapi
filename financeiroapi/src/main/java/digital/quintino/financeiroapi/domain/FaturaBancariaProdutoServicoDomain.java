package digital.quintino.financeiroapi.domain;

import java.io.Serializable;

public class FaturaBancariaProdutoServicoDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private FaturaBancariaDomain faturaBancariaDomain;
	
	private ProdutoServicoDomain produtoServicoDomain;
	
	private Double valorTotal;
	
	public FaturaBancariaProdutoServicoDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public FaturaBancariaDomain getFaturaBancariaDomain() {
		return faturaBancariaDomain;
	}

	public void setFaturaBancariaDomain(FaturaBancariaDomain faturaBancariaDomain) {
		this.faturaBancariaDomain = faturaBancariaDomain;
	}

	public ProdutoServicoDomain getProdutoServicoDomain() {
		return produtoServicoDomain;
	}

	public void setProdutoServicoDomain(ProdutoServicoDomain produtoServicoDomain) {
		this.produtoServicoDomain = produtoServicoDomain;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
