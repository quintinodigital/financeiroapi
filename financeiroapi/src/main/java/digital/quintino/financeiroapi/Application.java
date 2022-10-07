package digital.quintino.financeiroapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import digital.quintino.financeiroapi.domain.AcessoDomain;
import digital.quintino.financeiroapi.domain.InstituicaoFinanceiraDomain;
import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraDomain;
import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraParcelaDomain;
import digital.quintino.financeiroapi.domain.ParcelaDomain;
import digital.quintino.financeiroapi.domain.PessoaDomain;
import digital.quintino.financeiroapi.domain.TipoAcessoDomain;
import digital.quintino.financeiroapi.domain.TipoNegociacaoFinanceiraDomain;
import digital.quintino.financeiroapi.domain.TipoPessoaDomain;
import digital.quintino.financeiroapi.enumeration.TipoRecuperacaoAcessoEnumeration;
import digital.quintino.financeiroapi.repository.InstituicaoFinanceiraRepository;
import digital.quintino.financeiroapi.repository.NegociacaoFinanceiraInterfaceRepository;
import digital.quintino.financeiroapi.repository.NegociacaoFinanceiraParcelaInterfaceRepository;
import digital.quintino.financeiroapi.repository.ParcelaInterfaceRepository;
import digital.quintino.financeiroapi.repository.TipoAcessoInterfaceRepository;
import digital.quintino.financeiroapi.repository.TipoNegociacaoFinanceiraRepository;
import digital.quintino.financeiroapi.repository.TipoPessoaInterfaceRepository;
import digital.quintino.financeiroapi.service.AcessoService;
import digital.quintino.financeiroapi.service.PessoaService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private TipoPessoaInterfaceRepository tipoPessoaInterfaceRepository;
	
	@Autowired
	private TipoAcessoInterfaceRepository tipoAcessoInterfaceRepository;
	
	@Autowired
	private AcessoService acessoService;
	
	@Autowired
	private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;
	
	@Autowired
	private TipoNegociacaoFinanceiraRepository tipoNegociacaoFinanceiraRepository;
	
	@Autowired
	private NegociacaoFinanceiraInterfaceRepository negociacaoFinanceiraInterfaceRepository;
	
	@Autowired
	private ParcelaInterfaceRepository parcelaInterfaceRepository;
	
	@Autowired
	private NegociacaoFinanceiraParcelaInterfaceRepository negociacaoFinanceiraParcelaInterfaceRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		TipoPessoaDomain tipoPessoaDomain1 = new TipoPessoaDomain("Pessoa Física");
		TipoPessoaDomain tipoPessoaDomain2 = new TipoPessoaDomain("Pessoa Jurídica");
		
			this.tipoPessoaInterfaceRepository.saveAll(Arrays.asList(tipoPessoaDomain1, tipoPessoaDomain2));
		
		PessoaDomain pessoaDomain1 = new PessoaDomain(tipoPessoaDomain1, "José Quintino");
		PessoaDomain pessoaDomain2 = new PessoaDomain(tipoPessoaDomain2, "Banco do Brasil");
		List<PessoaDomain> pessoaDomainList = new ArrayList<>();
			pessoaDomainList.add(pessoaDomain1);
			pessoaDomainList.add(pessoaDomain2);
			
			this.pessoaService.saveAll(pessoaDomainList);
			
		TipoAcessoDomain tipoAcessoDomain1 = new TipoAcessoDomain("Aplicativo");
		TipoAcessoDomain tipoAcessoDomain2 = new TipoAcessoDomain("Operações Bancárias");
		
			this.tipoAcessoInterfaceRepository.saveAll(Arrays.asList(tipoAcessoDomain1, tipoAcessoDomain2));
			
		AcessoDomain acessoDomain1 = new AcessoDomain(tipoAcessoDomain1, TipoRecuperacaoAcessoEnumeration.EMAIL, pessoaDomain1, pessoaDomain2, "999999991", "<SENHA_APLICATIVO>", new Date());
		
		AcessoDomain acessoDomain2 = new AcessoDomain(tipoAcessoDomain2, TipoRecuperacaoAcessoEnumeration.SMS, pessoaDomain1, pessoaDomain2, "999999992", "<SENHA_OPERACAO_BANCARIA>", new Date());
		
			this.acessoService.saveAll(Arrays.asList(acessoDomain1, acessoDomain2));
			
		InstituicaoFinanceiraDomain instituicaoFinanceiraDomain1 = new InstituicaoFinanceiraDomain();
			instituicaoFinanceiraDomain1.setPessoaDomain(pessoaDomain2);
			
			this.instituicaoFinanceiraRepository.save(instituicaoFinanceiraDomain1);
			
		TipoNegociacaoFinanceiraDomain tipoNegociacaoFinanceiraDomain1 = new TipoNegociacaoFinanceiraDomain();
			tipoNegociacaoFinanceiraDomain1.setDescricao("Negociação Bancária");
			
			this.tipoNegociacaoFinanceiraRepository.save(tipoNegociacaoFinanceiraDomain1);
			
		NegociacaoFinanceiraDomain negociacaoFinanceiraDomain1 = new NegociacaoFinanceiraDomain();
			negociacaoFinanceiraDomain1.setTipoNegociacaoFinanceiraDomain(tipoNegociacaoFinanceiraDomain1);
			negociacaoFinanceiraDomain1.setDataNegociacao(new Date());
			negociacaoFinanceiraDomain1.setDiaVencimento(20);
			negociacaoFinanceiraDomain1.setValorParcela((double) 800);
			negociacaoFinanceiraDomain1.setQuantidadeParcelas(11);
			
			this.negociacaoFinanceiraInterfaceRepository.save(negociacaoFinanceiraDomain1);
			
		ParcelaDomain parcelaDomain1 = new ParcelaDomain();
			parcelaDomain1.setIdentificador("PARCELA2022001");
			parcelaDomain1.setDataVencimento(new Date());
			parcelaDomain1.setDataPagamento(null);
			parcelaDomain1.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain2 = new ParcelaDomain();
			parcelaDomain2.setIdentificador("PARCELA2022002");
			parcelaDomain2.setDataVencimento(new Date());
			parcelaDomain2.setDataPagamento(null);
			parcelaDomain2.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain3 = new ParcelaDomain();
			parcelaDomain3.setIdentificador("PARCELA2022003");
			parcelaDomain3.setDataVencimento(new Date());
			parcelaDomain3.setDataPagamento(null);
			parcelaDomain3.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain4 = new ParcelaDomain();
			parcelaDomain4.setIdentificador("PARCELA2022004");
			parcelaDomain4.setDataVencimento(new Date());
			parcelaDomain4.setDataPagamento(null);
			parcelaDomain4.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain5 = new ParcelaDomain();
			parcelaDomain5.setIdentificador("PARCELA2022005");
			parcelaDomain5.setDataVencimento(new Date());
			parcelaDomain5.setDataPagamento(null);
			parcelaDomain5.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain6 = new ParcelaDomain();
			parcelaDomain6.setIdentificador("PARCELA2022006");
			parcelaDomain6.setDataVencimento(new Date());
			parcelaDomain6.setDataPagamento(null);
			parcelaDomain6.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain7 = new ParcelaDomain();
			parcelaDomain7.setIdentificador("PARCELA2022007");
			parcelaDomain7.setDataVencimento(new Date());
			parcelaDomain7.setDataPagamento(null);
			parcelaDomain7.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain8 = new ParcelaDomain();
			parcelaDomain8.setIdentificador("PARCELA2022008");
			parcelaDomain8.setDataVencimento(new Date());
			parcelaDomain8.setDataPagamento(null);
			parcelaDomain8.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain9 = new ParcelaDomain();
			parcelaDomain9.setIdentificador("PARCELA2022009");
			parcelaDomain9.setDataVencimento(new Date());
			parcelaDomain9.setDataPagamento(null);
			parcelaDomain9.setValorTotal((double) 800);
	
		ParcelaDomain parcelaDomain10 = new ParcelaDomain();
			parcelaDomain10.setIdentificador("PARCELA2022010");
			parcelaDomain10.setDataVencimento(new Date());
			parcelaDomain10.setDataPagamento(null);
			parcelaDomain10.setValorTotal((double) 800);
			
		ParcelaDomain parcelaDomain11 = new ParcelaDomain();
			parcelaDomain11.setIdentificador("PARCELA2022011");
			parcelaDomain11.setDataVencimento(new Date());
			parcelaDomain11.setDataPagamento(null);
			parcelaDomain11.setValorTotal((double) 800);
			
			this.parcelaInterfaceRepository.saveAll(Arrays.asList(parcelaDomain1, parcelaDomain2, parcelaDomain3, parcelaDomain4, parcelaDomain5, parcelaDomain6, parcelaDomain7, parcelaDomain8, parcelaDomain9, parcelaDomain10, parcelaDomain11));
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain1 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain1);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain2 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain2);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain3 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain3);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain4 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain4);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain5 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain5);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain6 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain6);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain7 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain7);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain8 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain8);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain9 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain9);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain10 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date());
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain10);
			
		NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraParcelaDomain11 = new NegociacaoFinanceiraParcelaDomain();
			negociacaoFinanceiraParcelaDomain1.setDataPagamento(null);
			negociacaoFinanceiraParcelaDomain1.setDataVencimento(new Date()); 
			negociacaoFinanceiraParcelaDomain1.setNegociacaoFinanceiraDomain(negociacaoFinanceiraDomain1);
			negociacaoFinanceiraParcelaDomain1.setParcelaDomain(parcelaDomain11);
			
			this.negociacaoFinanceiraParcelaInterfaceRepository.saveAll(Arrays.asList(negociacaoFinanceiraParcelaDomain1, negociacaoFinanceiraParcelaDomain2, negociacaoFinanceiraParcelaDomain3, negociacaoFinanceiraParcelaDomain4, negociacaoFinanceiraParcelaDomain5, negociacaoFinanceiraParcelaDomain6, negociacaoFinanceiraParcelaDomain7, negociacaoFinanceiraParcelaDomain8, negociacaoFinanceiraParcelaDomain9, negociacaoFinanceiraParcelaDomain10, negociacaoFinanceiraParcelaDomain11));
		
	}

}
