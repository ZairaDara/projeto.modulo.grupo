package entities;

import entities.enums.TipoConta;

import java.math.BigDecimal;

public class ContaCorrente extends ContaNova{

    private TipoConta tipoConta = entities.enums.TipoConta.CONTA_CORRENTE;

    public TipoConta getTipoConta() {
        return tipoConta;
    }
    public ContaCorrente(Integer idConta, Cliente cliente) {
        super(idConta, cliente);
    }

}
