package entities;

import entities.enums.TipoPessoa;

public class ClientePJ extends Cliente{
    private String cnpjCliente = "00000000000000";

    private final String tipoPessoaCliente = TipoPessoa.PESSOA_JURIDICA.toString();

    public ClientePJ(String idCliente, String nomeCliente) {
        this.cnpjCliente = idCliente;
        super.setNomeCliente(nomeCliente);
    }

    public String getIdCliente() {
        return cnpjCliente;
    }

    public void setIdCliente(String idCliente) {
        this.cnpjCliente = idCliente;
    }

    public String getTipoPessoaCliente() {
        return tipoPessoaCliente;
    }
}
