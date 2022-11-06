package entities;

public class ContasCliente {
    private String IDCliente = "00000000000000";
    private Integer IDContaCorrente = 0;
    private Integer IDContaPoupanca = 0;
    private Integer IDContaInvestimento = 0;

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
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

    public ContasCliente(String IDCliente, Integer IDContaCorrente, Integer IDContaPoupanca, Integer IDContaInvestimento) {
        this.IDCliente = IDCliente;
        this.IDContaCorrente = IDContaCorrente;
        this.IDContaPoupanca = IDContaPoupanca;
        this.IDContaInvestimento = IDContaInvestimento;
    }

    @Override
    public String toString() {
        return "ContasCliente{" +
                "Identificador do Cliente='" + IDCliente + '\'' +
                ", Conta Corrente=" + IDContaCorrente +
                ", Conta Poupanca=" + IDContaPoupanca +
                ", Conta Investimento=" + IDContaInvestimento +
                '}';
    }
}
