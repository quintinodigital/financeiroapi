package digital.quintino.financeiroapi.service;

import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraParcelaDomain;
import digital.quintino.financeiroapi.repository.NegociacaoFinanceiraParcelaInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegociacaoFinanceiraParcelamentoService {

    @Autowired
    private NegociacaoFinanceiraParcelaInterfaceRepository negociacaoFinanceiraParcelaInterfaceRepository;

    public NegociacaoFinanceiraParcelaDomain saveOne(NegociacaoFinanceiraParcelaDomain negociacaoFinanceiraDomain) {
        return this.negociacaoFinanceiraParcelaInterfaceRepository.save(negociacaoFinanceiraDomain);
    }

}
