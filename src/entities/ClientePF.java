package entities;

import entities.enums.TipoPessoa;

public class ClientePF extends Cliente {
    private String cpfCliente = "00000000000";
    private final TipoPessoa tipoPessoaCliente = TipoPessoa.PESSOA_FISICA;

    public ClientePF(String idCliente, String nomeCliente) {
        this.cpfCliente = idCliente;
        super.setNomeCliente(nomeCliente);
    }

    public void setIdCliente(String idCliente) {
        cpfCliente = idCliente;
    }

    @Override
    public void setNomeCliente(String nomeCliente) {
        super.setNomeCliente(nomeCliente);
    }

    @Override
    public String getIdCliente() {
        return cpfCliente;
    }

    @Override
    public TipoPessoa getTipoPessoa() {
        return this.tipoPessoaCliente;
    }


}
