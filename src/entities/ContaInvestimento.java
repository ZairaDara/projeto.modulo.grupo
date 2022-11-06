package entities;

import entities.enums.TipoConta;
import entities.enums.TipoPessoa;

import java.math.BigDecimal;

public class ContaInvestimento extends ContaNova {
    private TipoConta tipoConta = entities.enums.TipoConta.CONTA_INVESTIMENTO;

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public ContaInvestimento(Integer idConta, Cliente cliente) {
        super(idConta, cliente);
    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_FISICA) {
            valorDeposito = valorDeposito.add(Parametros.TX_RENDIMENTO_CI_PF.multiply(valorDeposito).divide(new BigDecimal(100)));
        } else if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_JURIDICA) {
            valorDeposito = valorDeposito.add(Parametros.TX_RENDIMENTO_CI_PJ.multiply(valorDeposito).divide(new BigDecimal(100)));
        }

        super.depositar(valorDeposito);

    }
}
