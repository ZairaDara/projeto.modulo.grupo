package entities;

import entities.enums.TipoPessoa;

public abstract class Cliente {
    private String nomeCliente = "Nome";

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public abstract Object getIdCliente();

    public abstract TipoPessoa getTipoPessoa ();

    @Override
    public String toString() {
        return "Cliente{" +
                "Identificador='" + this.getIdCliente() + '\'' +
                "Cliente='" + nomeCliente + '\'' +
                '}';
    }
}
