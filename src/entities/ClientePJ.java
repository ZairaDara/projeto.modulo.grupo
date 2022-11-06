package entities;

import entities.enums.TipoPessoa;

public class ClientePJ extends Cliente{
    private String cnpjCliente = "00000000000000";

    private final TipoPessoa tipoPessoaCliente = TipoPessoa.PESSOA_JURIDICA;

    public ClientePJ(String idCliente, String nomeCliente) {
        this.cnpjCliente = idCliente;
        super.setNomeCliente(nomeCliente);
    }

    public String getIdCliente() {
        return cnpjCliente;
    }

    @Override
    public TipoPessoa getTipoPessoa() {
        return this.tipoPessoaCliente;
    }

    public void setIdCliente(String idCliente) {
        this.cnpjCliente = idCliente;
    }




}
