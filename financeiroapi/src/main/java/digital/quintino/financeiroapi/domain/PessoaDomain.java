package digital.quintino.financeiroapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "ID_TIPO_PESSOA")
	private TipoPessoaDomain tipoPessoaDomain;
	
	@Column(name = "NOME", length = 100, unique = true, nullable = false)
	private String nome;
	
	public PessoaDomain() { }

	public PessoaDomain(TipoPessoaDomain tipoPessoaDomain, String nome) {
		this.tipoPessoaDomain = tipoPessoaDomain;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoPessoaDomain getTipoPessoaDomain() {
		return tipoPessoaDomain;
	}

	public void setTipoPessoaDomain(TipoPessoaDomain tipoPessoaDomain) {
		this.tipoPessoaDomain = tipoPessoaDomain;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
