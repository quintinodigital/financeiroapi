package digital.quintino.financeiroapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INSTITUICAO_FINANCEIRA")
public class InstituicaoFinanceiraDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@JoinColumn(name = "ID_PESSOA")
	@OneToOne
	private PessoaDomain pessoaDomain;

	public InstituicaoFinanceiraDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PessoaDomain getPessoaDomain() {
		return pessoaDomain;
	}

	public void setPessoaDomain(PessoaDomain pessoaDomain) {
		this.pessoaDomain = pessoaDomain;
	}

}
