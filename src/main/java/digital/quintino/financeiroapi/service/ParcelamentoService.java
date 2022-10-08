package digital.quintino.financeiroapi.service;

import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraDomain;
import digital.quintino.financeiroapi.domain.NegociacaoFinanceiraParcelaDomain;
import digital.quintino.financeiroapi.domain.ParcelaDomain;
import digital.quintino.financeiroapi.repository.ParcelaInterfaceRepository;
import digital.quintino.financeiroapi.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParcelamentoService {

    @Autowired
    private ParcelaInterfaceRepository parcelaInterfaceRepository;

    @Autowired
    private NegociacaoFinanceiraParcelamentoService negociacaoFinanceiraParcelamentoService;

    public void saveOne(NegociacaoFinanceiraDomain negociacaoFinanceiraDomain) {
        for( int index = 1 ; index <= negociacaoFinanceiraDomain.getQuantidadeParcelas() ; index++ ) {
            ParcelaDomain parcelaDomain = new ParcelaDomain();
                parcelaDomain.setValor(negociacaoFinanceiraDomain.getValorParcela());
                parcelaDomain.setIdentificador("PARCELANEGOCIACAO012022" + (index < 10 ? "0" + index : index));
                parcelaDomain.setDataVencimento(this.configurarDataVencimentoParcela(negociacaoFinanceiraDomain.getDiaVencimento(), index));
                parcelaDomain.setDataPagamento(null);
            ParcelaDomain parcelaDomainPersistida = this.parcelaInterfaceRepository.save(parcelaDomain);
            this.negociacaoFinanceiraParcelamentoService.saveOne(new NegociacaoFinanceiraParcelaDomain(new NegociacaoFinanceiraDomain(negociacaoFinanceiraDomain.getCodigo()), new ParcelaDomain(parcelaDomainPersistida.getCodigo())));
        }
    }

    private Date configurarDataVencimentoParcela(Integer diaVencimento, Integer mesVencimento) {
        return DateUtility.gerarData(diaVencimento, mesVencimento);
    }

}
