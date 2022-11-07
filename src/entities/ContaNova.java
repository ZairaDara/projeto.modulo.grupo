package entities;

import entities.enums.TipoConta;
import entities.enums.TipoPessoa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ContaNova {
    protected Integer idConta = 0;

    protected Cliente cliente;
    private BigDecimal saldo = BigDecimal.valueOf(0).setScale(4, RoundingMode.HALF_EVEN);

    public Integer getIDConta() {
        return idConta;
    }
    public void setIDConta(Integer idConta) {
        this.idConta = idConta;
    }
    public String getIDCliente() {
        return cliente.getIdCliente().toString();
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo.setScale(4,RoundingMode.HALF_EVEN);
    }

    public ContaNova(Integer idConta, Cliente cliente){
        this.idConta = idConta;
        this.cliente = cliente;
    }

    public void depositar (BigDecimal valorDeposito) {
        this.saldo = this.saldo.add(valorDeposito);
    }

    public void sacar (BigDecimal valorSaque) {
        if (this.saldo.compareTo(valorSaque) > 0 ){
            if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_JURIDICA){
                valorSaque =  valorSaque.add(valorSaque.multiply(Parametros.TX_TRANSACAO_PJ).divide(new BigDecimal(100))) ;
            }

            this.saldo = this.saldo.subtract(valorSaque);
        }else{
            System.out.println("Valor do Saldo insuficiente para saque.");
        }

    }

    public abstract TipoConta getTipoConta();

    @Override
    public String toString() {
        return "ContaNova{" +
                "idConta=" + idConta +
                ", idCliente='" + cliente.getIdCliente() + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
