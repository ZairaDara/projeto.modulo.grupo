package application;

import entities.*;
import entities.enums.TipoConta;
import entities.enums.TipoPessoa;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Locale;
import java.util.Scanner;

public class GestaoClientesContas {
    public static List<Cliente> baseClientes = new ArrayList<Cliente>();
    public static List<ContasCliente> baseContasCliente = new ArrayList<ContasCliente>();
    public static List<ContaNova> baseContas = new ArrayList<ContaNova>();

    private static Integer idContaCorrenteMax;

    private static Integer idContaPoupancaMax;

    private static Integer idContaInvestimentoMax;

    private static Integer idContaInvestimento;

    private static Integer idContaPoupanca;

    private static Integer idContaCorrente;

    public void setIdContaCorrenteMax(Integer idContaCorrenteMax) {
        this.idContaCorrenteMax = idContaCorrenteMax;
    }
    public void setIdContaPoupancaMax(Integer idContaPoupancaMax) {
        this.idContaPoupancaMax = idContaPoupancaMax;
    }

    public void setIdContaInvestimentoMax(Integer idContaInvestimentoMax) {
        this.idContaInvestimentoMax = idContaInvestimentoMax;
    }

    public Integer getIdContaCorrenteMax() {
        return this.idContaCorrenteMax;
    }

    public Integer getIdContaPoupancaMax() {
        return this.idContaPoupancaMax;
    }

    public Integer getIdContaInvestimentoMax() {
        return this.idContaInvestimentoMax;
    }

    public static Integer getIdContaInvestimento() {
        return idContaInvestimento;
    }

    public static void setIdContaInvestimento(Integer idContaInvestimento) {
        GestaoClientesContas.idContaInvestimento = idContaInvestimento;
    }

    public static Integer getIdContaPoupanca() {
        return idContaPoupanca;
    }

    public static void setIdContaPoupanca(Integer idContaPoupanca) {
        GestaoClientesContas.idContaPoupanca = idContaPoupanca;
    }

    public static Integer getIdContaCorrente() {
        return idContaCorrente;
    }

    public static void setIdContaCorrente(Integer idContaCorrente) {
        GestaoClientesContas.idContaCorrente = idContaCorrente;
    }

    public boolean criarCliente(String idCliente, String nomeCliente, String tipoPessoa) {
        if (tipoPessoa.equals(TipoPessoa.PESSOA_FISICA.toString())) {
            Cliente novoCliente = new ClientePF(idCliente, nomeCliente);
            baseClientes.add(novoCliente);
            return true;
        } else if (tipoPessoa.equals(TipoPessoa.PESSOA_JURIDICA.toString())) {
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

    public boolean validaContasCliente(String IDCliente, Integer IDContaCorrente, Integer IDContaPoupanca, Integer IDContaInvestimento) {
        ContasCliente contasCliente = new ContasCliente(IDCliente, IDContaCorrente, IDContaPoupanca, IDContaInvestimento);
        boolean valida = false;
        for (ContasCliente c : baseContasCliente) {
            if (IDCliente.equals(c.getIDCliente().toString())) {
                idContaInvestimento = c.getIDContaInvestimento();
                idContaPoupanca = c.getIDContaPoupanca();
                idContaCorrente = c.getIDContaCorrente();
                valida = true;
            }
        }
        return valida;
    }

    public boolean criarConta(Integer idContaCorrente, Integer idContaPoupanca,Integer idContaInvestimento, String idCliente, String tipoConta) {
        if (tipoConta.equals(TipoConta.CONTA_CORRENTE.toString())) {
            ContaNova novaConta = new ContaCorrente(idContaCorrente, idCliente);
            baseContas.add(novaConta);
            return true;
        } else if (tipoConta.equals(TipoConta.CONTA_POUPANCA.toString())) {
            ContaNova novaConta = new ContaPoupanca(idContaPoupanca, idCliente);
            baseContas.add(novaConta);
            return true;
        } else if (tipoConta.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
            ContaNova novaConta = new ContaInvestimento(idContaInvestimento, idCliente);
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

    public boolean atualizaNovoCadastro(String idCliente, Integer idContaCorrente, Integer idContaPoupanca, Integer
            idContaInvestimento) {
        ContasCliente atualizaCadastro = new ContasCliente(idCliente, idContaCorrente, idContaPoupanca, idContaInvestimento);
        boolean valida = false;
        for (ContasCliente c : baseContasCliente) {
            if (idCliente.equals(c.getIDCliente().toString())) {
                if (idCliente.equals(c.getIDCliente().toString())) {
                    c.setIDContaCorrente(idContaCorrente);
                    c.setIDContaInvestimento(idContaInvestimento);
                    c.setIDContaPoupanca(idContaPoupanca);
                    valida = true;
                }
            }
        }
        return valida;
    }

    public boolean atualizaConta(Integer idContaCorrente, Integer idContaPoupanca,Integer idContaInvestimento, String idCliente, String tipoConta) {
        boolean valida = false;
        if (tipoConta.equals(TipoConta.CONTA_CORRENTE.toString())) {
            ContaNova novaConta = new ContaCorrente(idContaCorrente, idCliente);
            for (ContaNova c: baseContas){
                if (idCliente.equals(c.getIDCliente().toString())){
                    novaConta.setIDConta(idContaCorrente);
                    valida = true;
                }
            }
        } else if (tipoConta.equals(TipoConta.CONTA_POUPANCA.toString())) {
            ContaNova novaConta = new ContaPoupanca(idContaPoupanca, idCliente);
            for (ContaNova c: baseContas){
                if (idCliente.equals(c.getIDCliente().toString())){
                    novaConta.setIDConta(idContaPoupanca);
                    valida = true;
                }
            }
        } else if (tipoConta.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
            ContaNova novaConta = new ContaInvestimento(idContaInvestimento, idCliente);
            for (ContaNova c: baseContas){
                if (idCliente.equals(c.getIDCliente().toString())){
                    novaConta.setIDConta(idContaInvestimento);
                    valida = true;
                }
            }
        } else {
            System.out.println("Falha para atualizar baseContas");
            valida = false;
        }
        return valida;
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
