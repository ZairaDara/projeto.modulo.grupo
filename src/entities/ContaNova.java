package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaNova {
    protected Integer idConta = 0;
    protected String idCliente = "00000000000000";
    private BigDecimal saldo = BigDecimal.valueOf(0).setScale(4, RoundingMode.HALF_EVEN);

    public Integer getIDConta() {
        return idConta;
    }
    public void setIDConta(Integer idConta) {
        this.idConta = idConta;
    }
    public String getIDCliente() {
        return idCliente;
    }
    public void setIDCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo.setScale(4,RoundingMode.HALF_EVEN);
    }

    public ContaNova(Integer idConta, String idCliente){
        this.idConta = idConta;
        this.idCliente = idCliente;
    }
}
