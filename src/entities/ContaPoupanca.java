package entities;

public class ContaPoupanca extends ContaNova{
    private String TipoConta = entities.enums.TipoConta.CONTA_POUPANCA.toString();

    public String getTipoConta() {
        return TipoConta;
    }
    public ContaPoupanca(Integer idConta, String idCliente) {
        super(idConta, idCliente);
    }
}
