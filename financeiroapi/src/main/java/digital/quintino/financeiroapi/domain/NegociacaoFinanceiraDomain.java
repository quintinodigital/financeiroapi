package digital.quintino.financeiroapi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NEGOCIACAO_FINANCEIRA")
public class NegociacaoFinanceiraDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@JoinColumn(name = "ID_TIPO_NEGOCIACAO_FINANCEIRA")
	@OneToOne
	private TipoNegociacaoFinanceiraDomain tipoNegociacaoFinanceiraDomain;
	
	@Column(name = "DATA_NEGOCIACAO", nullable = false)
	private Date dataNegociacao;
	
	@Column(name = "VALOR_PARCELA")
	private Double valorParcela;
	
	@Column(name = "DIA_VENCIMENTO", nullable = false)
	private Integer diaVencimento;
	
	@Column(name = "QUANTIDADE_PARCELAS", nullable = false)
	private Integer quantidadeParcelas;
	
	public NegociacaoFinanceiraDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoNegociacaoFinanceiraDomain getTipoNegociacaoFinanceiraDomain() {
		return tipoNegociacaoFinanceiraDomain;
	}

	public void setTipoNegociacaoFinanceiraDomain(TipoNegociacaoFinanceiraDomain tipoNegociacaoFinanceiraDomain) {
		this.tipoNegociacaoFinanceiraDomain = tipoNegociacaoFinanceiraDomain;
	}

	public Date getDataNegociacao() {
		return dataNegociacao;
	}

	public void setDataNegociacao(Date dataNegociacao) {
		this.dataNegociacao = dataNegociacao;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

}
