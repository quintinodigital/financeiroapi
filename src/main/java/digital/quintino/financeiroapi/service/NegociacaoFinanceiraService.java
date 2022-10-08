package digital.quintino.financeiroapi.service;

import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraDomain;
import digital.quintino.financeiroapi.repository.NegociacaoFinanceiraInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegociacaoFinanceiraService {

    @Autowired
    private NegociacaoFinanceiraInterfaceRepository negociacaoFinanceiraInterfaceRepository;

    @Autowired
    private ParcelamentoService parcelamentoService;

    public NegociacaoFinanceiraDomain saveOne(NegociacaoFinanceiraDomain negociacaoFinanceiraDomain) {
        NegociacaoFinanceiraDomain negociacaoFinanceiraDomainParsistida = this.negociacaoFinanceiraInterfaceRepository.save(negociacaoFinanceiraDomain);
        this.parcelamentoService.saveOne(negociacaoFinanceiraDomainParsistida);
        return negociacaoFinanceiraDomainParsistida;
    }

}
