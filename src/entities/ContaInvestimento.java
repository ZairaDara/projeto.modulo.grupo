package entities;

public class ContaInvestimento extends ContaNova{
    private String TipoConta = entities.enums.TipoConta.CONTA_INVESTIMENTO.toString();

    public String getTipoConta() {
        return TipoConta;
    }
    public ContaInvestimento(Integer idConta, String idCliente) {
        super(idConta, idCliente);
    }

}
