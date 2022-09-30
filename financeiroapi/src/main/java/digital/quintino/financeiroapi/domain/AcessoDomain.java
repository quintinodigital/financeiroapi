package digital.quintino.financeiroapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import digital.quintino.financeiroapi.enumeration.TipoRecuperacaoAcessoEnumeration;

@Entity
@Table(name = "TB_ACESSO")
public class AcessoDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name = "ID_TIPO_ACESSO")
	private TipoAcessoDomain tipoAcessoDomain;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ID_TIPO_RECUPERACAO")
	private TipoRecuperacaoAcessoEnumeration tipoRecuperacaoAcessoEnumeration;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ID_PESSOA_RESPONSAVEL")
	private PessoaDomain pessoaResponsavel;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ID_PESSOA_MONITORADA")
	private PessoaDomain pessoaMonitorada;
	
	@Column(name = "IDENTIFICADOR", length = 100, nullable = false)
	private String identificador;
	
	@Column(name = "CHAVE", length = 100, nullable = false)
	private String chave;
	
	@Column(name = "URL", length = 100)
	private String URL;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EXPIRACAO")
	private Date dataExpiracao;
	
	public AcessoDomain() { }

	public AcessoDomain(TipoAcessoDomain tipoAcessoDomain, PessoaDomain pessoaResponsavel, String identificador, String chave, Date dataCriacao) {
		this.tipoAcessoDomain = tipoAcessoDomain;
		this.pessoaResponsavel = pessoaResponsavel;
		this.identificador = identificador;
		this.chave = chave;
		this.dataCriacao = dataCriacao;
	}

	public AcessoDomain(TipoAcessoDomain tipoAcessoDomain, TipoRecuperacaoAcessoEnumeration tipoRecuperacaoAcessoEnumeration, PessoaDomain pessoaResponsavel, PessoaDomain pessoaMonitorada, String identificador, String chave, Date dataCriacao) {
		this.tipoAcessoDomain = tipoAcessoDomain;
		this.tipoRecuperacaoAcessoEnumeration = tipoRecuperacaoAcessoEnumeration;
		this.pessoaResponsavel = pessoaResponsavel;
		this.pessoaMonitorada = pessoaMonitorada;
		this.identificador = identificador;
		this.chave = chave;
		this.dataCriacao = dataCriacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public TipoAcessoDomain getTipoAcessoDomain() {
		return tipoAcessoDomain;
	}

	public void setTipoAcessoDomain(TipoAcessoDomain tipoAcessoDomain) {
		this.tipoAcessoDomain = tipoAcessoDomain;
	}

	public TipoRecuperacaoAcessoEnumeration getTipoRecuperacaoAcessoEnumeration() {
		return tipoRecuperacaoAcessoEnumeration;
	}

	public void setTipoRecuperacaoAcessoEnumeration(TipoRecuperacaoAcessoEnumeration tipoRecuperacaoAcessoEnumeration) {
		this.tipoRecuperacaoAcessoEnumeration = tipoRecuperacaoAcessoEnumeration;
	}

	public PessoaDomain getPessoaResponsavel() {
		return pessoaResponsavel;
	}

	public void setPessoaResponsavel(PessoaDomain pessoaResponsavel) {
		this.pessoaResponsavel = pessoaResponsavel;
	}

	public PessoaDomain getPessoaMonitorada() {
		return pessoaMonitorada;
	}

	public void setPessoaMonitorada(PessoaDomain pessoaMonitorada) {
		this.pessoaMonitorada = pessoaMonitorada;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

}
