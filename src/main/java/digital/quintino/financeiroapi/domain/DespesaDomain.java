package digital.quintino.financeiroapi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_DESPESA")
public class DespesaDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Long codigo;

    @OneToOne
    @JoinColumn(name = "ID_TIPO_DESPESA", nullable = false)
    private TipoDespesaDomain tipoDespesaDomain;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_FAVORECIDO")
    private PessoaDomain pessoaFavorecido;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private Date dataVencimento;

    @Column(name = "DATA_PAGAMENTO")
    private Date dataPagamento;

    public DespesaDomain() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoDespesaDomain getTipoDespesaDomain() {
        return tipoDespesaDomain;
    }

    public void setTipoDespesaDomain(TipoDespesaDomain tipoDespesaDomain) {
        this.tipoDespesaDomain = tipoDespesaDomain;
    }

    public PessoaDomain getPessoaFavorecido() {
        return pessoaFavorecido;
    }

    public void setPessoaFavorecido(PessoaDomain pessoaFavorecido) {
        this.pessoaFavorecido = pessoaFavorecido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
