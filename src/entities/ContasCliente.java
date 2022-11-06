package entities;

public class ContasCliente {

    private Cliente cliente;
    private Integer IDContaCorrente = 0;
    private Integer IDContaPoupanca = 0;
    private Integer IDContaInvestimento = 0;

    public String getIDCliente() {
        return cliente.getIdCliente().toString();
    }

    public Integer getIDContaCorrente() {
        return IDContaCorrente;
    }

    public void setIDContaCorrente(Integer IDContaCorrente) {
        this.IDContaCorrente = IDContaCorrente;
    }

    public Integer getIDContaPoupanca() {
        return IDContaPoupanca;
    }

    public void setIDContaPoupanca(Integer IDContaPoupanca) {
        this.IDContaPoupanca = IDContaPoupanca;
    }

    public Integer getIDContaInvestimento() {
        return IDContaInvestimento;
    }

    public void setIDContaInvestimento(Integer IDContaInvestimento) {
        this.IDContaInvestimento = IDContaInvestimento;
    }

    public ContasCliente(Cliente cliente, Integer IDContaCorrente, Integer IDContaPoupanca, Integer IDContaInvestimento) {
        this.cliente = cliente;
        this.IDContaCorrente = IDContaCorrente;
        this.IDContaPoupanca = IDContaPoupanca;
        this.IDContaInvestimento = IDContaInvestimento;
    }

    @Override
    public String toString() {
        return "ContasCliente{" +
                "Identificador do Cliente='" + cliente.getIdCliente() + '\'' +
                ", Conta Corrente=" + IDContaCorrente +
                ", Conta Poupanca=" + IDContaPoupanca +
                ", Conta Investimento=" + IDContaInvestimento +
                '}';
    }
}
