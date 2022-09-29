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
import digital.quintino.financeiroapi.domain.PessoaDomain;
import digital.quintino.financeiroapi.domain.TipoAcessoDomain;
import digital.quintino.financeiroapi.domain.TipoPessoaDomain;
import digital.quintino.financeiroapi.repository.TipoAcessoInterfaceRepository;
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
			
		AcessoDomain acessoDomain = new AcessoDomain(tipoAcessoDomain1, pessoaDomain1, "josequintino@hotmail.com.br", "<SENHA_QUALQUER>", new Date());
		
			this.acessoService.save(acessoDomain);
		
	}

}
