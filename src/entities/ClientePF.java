package entities;

import entities.enums.TipoPessoa;

public class ClientePF extends Cliente {
    private String cpfCliente = "00000000000";
    private final String tipoPessoaCliente = TipoPessoa.PESSOA_FISICA.toString();

    public ClientePF(String idCliente, String nomeCliente) {
        this.cpfCliente = idCliente;
        super.setNomeCliente(nomeCliente);
    }

    public String getTipoPessoaCliente() {
        return tipoPessoaCliente;
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


}
