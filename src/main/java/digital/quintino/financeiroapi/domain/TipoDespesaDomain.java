package digital.quintino.financeiroapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIPO_DESPESA")
public class TipoDespesaDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;

	@Column(name = "DESCRICAO", length = 100, unique = true, nullable = false)
	private String descricao;

	public TipoDespesaDomain() { }

	public TipoDespesaDomain(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
