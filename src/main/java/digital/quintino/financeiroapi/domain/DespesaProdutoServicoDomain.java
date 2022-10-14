package digital.quintino.financeiroapi.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_DESPESA_PRODUTO_SERVICO")
public class DespesaProdutoServicoDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "ID_DESPESA")
	private DespesaDomain despesaDomain;

	@ManyToOne
	@JoinColumn(name = "ID_PRODUTO_SERVICO")
	private ProdutoServicoDomain produtoServicoDomain;

	public DespesaProdutoServicoDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public DespesaDomain getDespesaDomain() {
		return despesaDomain;
	}

	public void setDespesaDomain(DespesaDomain despesaDomain) {
		this.despesaDomain = despesaDomain;
	}

	public ProdutoServicoDomain getProdutoServicoDomain() {
		return produtoServicoDomain;
	}

	public void setProdutoServicoDomain(ProdutoServicoDomain produtoServicoDomain) {
		this.produtoServicoDomain = produtoServicoDomain;
	}

}
