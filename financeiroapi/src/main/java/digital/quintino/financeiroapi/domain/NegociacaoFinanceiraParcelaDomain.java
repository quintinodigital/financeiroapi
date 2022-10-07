package digital.quintino.financeiroapi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NEGOCIACAO_FINANCEIRA_PARCELA")
public class NegociacaoFinanceiraParcelaDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_NEGOCIACAO_FINANCEIRA")
	private NegociacaoFinanceiraDomain negociacaoFinanceiraDomain;
	
	@ManyToOne
	@JoinColumn(name = "ID_PARCELA")
	private ParcelaDomain parcelaDomain;
	
	@Column(name = "DATA_VENCIMENTO")
	private Date dataVencimento;
	
	@Column(name = "DATA_PAGAMENTO")
	private Date DataPagamento;
	
	public NegociacaoFinanceiraParcelaDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public NegociacaoFinanceiraDomain getNegociacaoFinanceiraDomain() {
		return negociacaoFinanceiraDomain;
	}

	public void setNegociacaoFinanceiraDomain(NegociacaoFinanceiraDomain negociacaoFinanceiraDomain) {
		this.negociacaoFinanceiraDomain = negociacaoFinanceiraDomain;
	}

	public ParcelaDomain getParcelaDomain() {
		return parcelaDomain;
	}

	public void setParcelaDomain(ParcelaDomain parcelaDomain) {
		this.parcelaDomain = parcelaDomain;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return DataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}

}
