package entities;

public abstract class Cliente {
    private String nomeCliente = "Nome";

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public abstract Object getIdCliente();

    @Override
    public String toString() {
        return "Cliente{" +
                "Identificador='" + this.getIdCliente() + '\'' +
                "nomeCliente='" + nomeCliente + '\'' +
                '}';
    }
}
