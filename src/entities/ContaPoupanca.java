package entities;

import entities.enums.TipoConta;
import entities.enums.TipoPessoa;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaNova{
    private TipoConta tipoConta = entities.enums.TipoConta.CONTA_POUPANCA;

    public TipoConta getTipoConta() {
        return tipoConta;
    }
    public ContaPoupanca(Integer idConta, Cliente cliente) {
        super(idConta, cliente);
    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_FISICA) {
            valorDeposito = valorDeposito.add(Parametros.TX_RENDIMENTO_CP_PF.multiply(valorDeposito).divide(new BigDecimal(100)));
        }

        super.depositar(valorDeposito);
    }
}
