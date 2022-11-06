package application;

import entities.*;
import entities.enums.TipoConta;
import entities.enums.TipoPessoa;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestaoClientesContas {
    public static List<Cliente> baseClientes = new ArrayList<Cliente>();
    public List<ContasCliente> baseContasCliente = new ArrayList<ContasCliente>();
    public List<ContaNova> baseContas = new ArrayList<ContaNova>();

    private Integer idContaCorrenteMax;

    public Integer idContaCorrenteMax(){ return idContaCorrenteMax;}

    private Integer idContaPoupancaMax;

    public Integer idContaPoupancaMax(){ return idContaPoupancaMax;}

    private Integer idContaInvestimentoMax;

    public Integer idContaInvestimentoMax(){ return idContaInvestimentoMax;}

    public void setIdContaCorrenteMax(Integer idContaCorrenteMax) {
        this.idContaCorrenteMax = idContaCorrenteMax;
    }

    public void setIdContaPoupancaMax(Integer idContaPoupancaMax) {
        this.idContaPoupancaMax = idContaPoupancaMax;
    }

    public void setIdContaInvestimentoMax(Integer idContaInvestimentoMax) {
        this.idContaInvestimentoMax = idContaInvestimentoMax;
    }

    public boolean criarCliente(String idCliente, String nomeCliente, String tipoPessoa) {
        if (tipoPessoa.equals(TipoPessoa.PESSOA_FISICA.toString())){
            Cliente novoCliente = new ClientePF(idCliente, nomeCliente);
            baseClientes.add(novoCliente);
            return true;
        } else if (tipoPessoa.equals(TipoPessoa.PESSOA_JURIDICA.toString())){
            Cliente novoCliente = new ClientePJ(idCliente, nomeCliente);
            baseClientes.add(novoCliente);
            return true;
        } else {
            System.out.println("Tipo de pessoa inválido!");
            return false;
        }
    }

    public boolean validaIdCliente(String idCliente, String nomeCliente, String tipoPessoa) {
        boolean valida = false;
        if (tipoPessoa.equals("PESSOA_FISICA")) {
            Cliente cliente = new ClientePF(idCliente, nomeCliente);
            for (Cliente c : baseClientes) {
                if (idCliente.equals(c.getIdCliente().toString())) {
                    valida = true;
                }
            }
        } else if (tipoPessoa.equals("PESSOA_JURIDICA")) {
            Cliente cliente = new ClientePJ(idCliente, nomeCliente);
            for (Cliente c : baseClientes) {
                if (idCliente.equals(c.getIdCliente().toString())) {
                    valida = true;
                }
            }
        } else {
            valida = false;
        }
        return valida;
    }

    public void validaContasCliente(String IDCliente, Integer IDContaCorrente, Integer IDContaPoupanca, Integer IDContaInvestimento) {
        ContasCliente contasCliente = new ContasCliente(IDCliente, IDContaCorrente, IDContaPoupanca, IDContaInvestimento);
        for (ContasCliente c : baseContasCliente) {
            if (IDCliente.equals(c.getIDCliente().toString())) {
                Integer idContaCorrente = c.getIDContaCorrente();
                Integer idContaPoupanca = c.getIDContaPoupanca();
                Integer idContaInvestimento = c.getIDContaInvestimento();
            }
        }
    }
    public boolean criarConta(Integer idConta, String idCliente, String tipoConta) {
        if (tipoConta.equals(TipoConta.CONTA_CORRENTE.toString())) {
            ContaNova novaConta = new ContaCorrente(idConta, idCliente);
            baseContas.add(novaConta);
            return true;
        }else if(tipoConta.equals(TipoConta.CONTA_POUPANCA.toString())){
            ContaNova novaConta = new ContaPoupanca(idConta, idCliente);
            baseContas.add(novaConta);
            return true;
        } else if (tipoConta.equals(TipoConta.CONTA_INVESTIMENTO.toString())){
            ContaNova novaConta = new ContaInvestimento(idConta, idCliente);
            baseContas.add(novaConta);
            return true;
        } else {
            System.out.println("Tipo de Conta Inválido!");
            return false;
        }
    }

    public boolean criarNovoCadastro(String idCliente, Integer idContaCorrente, Integer idContaPoupanca, Integer
            idContaInvestimento) {
        ContasCliente novoCadastro = new ContasCliente(idCliente, idContaCorrente, idContaPoupanca, idContaInvestimento);
        baseContasCliente.add(novoCadastro);
        return true;
    }

    public void maxIdsContas() {
        Integer idContaCorrenteAtual = 0;
        Integer idContaPoupancaAtual = 0;
        Integer idContaInvestimentoAtual = 0;
        Integer idContaCorrenteAnterior = 0;
        Integer idContaPoupancaAnterior = 0;
        Integer idContaInvestimentoAnterior = 0;

        setIdContaCorrenteMax(0);
        setIdContaPoupancaMax(0);
        setIdContaInvestimentoMax(0);

        for (ContasCliente c : baseContasCliente) {
            idContaCorrenteAnterior = idContaCorrenteAtual;
            idContaPoupancaAnterior = idContaPoupancaAtual;
            idContaInvestimentoAnterior = idContaInvestimentoAtual;
            idContaCorrenteAtual = c.getIDContaCorrente();
            idContaPoupancaAtual = c.getIDContaPoupanca();
            idContaInvestimentoAtual = c.getIDContaInvestimento();
            if (idContaCorrenteAtual >= idContaCorrenteAnterior) {
                setIdContaCorrenteMax(idContaCorrenteAtual);
            } else {
                setIdContaCorrenteMax(idContaCorrenteAnterior);
            }
            if (idContaPoupancaAtual >= idContaPoupancaAnterior) {
                setIdContaPoupancaMax(idContaPoupancaAtual);
            } else {
                setIdContaPoupancaMax(idContaPoupancaAnterior);
            }
            if (idContaInvestimentoAtual >= idContaInvestimentoAnterior) {
                setIdContaInvestimentoMax(idContaInvestimentoAtual);
            } else {
                setIdContaInvestimentoMax(idContaInvestimentoAnterior);

            }
        }
    }
    public Integer getIdContaCorrenteMax() {
        return this.idContaCorrenteMax;
    }
    public Integer getIdContaInvestimentoMax(){
        return this.idContaInvestimentoMax;
    }
    public Integer getIdContaPoupancaMax(){
        return this.idContaPoupancaMax;
    }

    public int getIdContaCorrente() {
        return 0;
    }

    public int getIdContaInvestimento() {
        return 0;
    }

    public int getIdContaPoupanca() {
        return 0;
    }

    public void listaTodasAsContas() {

        for (int i = 0; i < this.baseClientes.size(); i++) {
            Cliente cliente = this.baseClientes.get(i);
            System.out.println(cliente);

            for (int j = 0; j < this.baseContasCliente.size(); j++) {
                ContasCliente contasCliente = this.baseContasCliente.get(j);
                if (cliente.getIdCliente().equals(contasCliente.getIDCliente())) {
                    System.out.println(contasCliente);
                    break;
                }
            }

        }

    }

    public Integer buscaContaCliente(String documento){
        if (this.baseClientes.size()==0) {
            System.out.println(" xxxxxx Cliente não possui conta. Crie uma conta para realizar a operação xxxxxx");
        }else {
             System.out.printf("busca a conta");
            for (int i = 0; i < this.baseContasCliente.size() ; i++) {
                ContasCliente contasCliente = this.baseContasCliente.get(i);
                Integer conta = contasCliente.getIDContaCorrente();
            }

        }


        return 0;
    }
//
//            for (int i = 0; i < this.baseContasCliente.size(); i++) {
//        ContasCliente contasCliente = this.baseContasCliente.get(i);
//        if (baseContasCliente..getIdCliente().equals(contasCliente.getIDCliente())) {
//            System.out.println(contasCliente);
//            break;
//        }
//    }



}
