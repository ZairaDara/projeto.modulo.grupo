package entities;

public class ContaCorrente extends ContaNova{
    private String TipoConta = entities.enums.TipoConta.CONTA_CORRENTE.toString();

    public String getTipoConta() {
        return TipoConta;
    }
    public ContaCorrente(Integer idConta, String idCliente) {
        super(idConta, idCliente);
    }
}
