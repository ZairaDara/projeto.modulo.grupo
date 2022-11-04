package application;

import entities.enums.TipoConta;
import entities.enums.TipoContaJuridica;
import entities.enums.TipoPessoa;

import java.util.Scanner;

public class CriadorConta {

    Scanner sc = new Scanner(System.in);

    public void criadorConta() {

        int i = 0;
        int j = 0;

        System.out.println("Digite o nome do responsavel: ");
        String nome = sc.next();

        System.out.println("Digite o documento do responsavel (CPF ou CNPJ): ");
        String documento = sc.next();

        String tipoPessoaIn2 = TipoPessoa(documento);

        System.out.println("Digite o tipo da conta desejado: ");
        if (tipoPessoaIn2.equals(TipoPessoa.PESSOA_FISICA.toString())) {
            for (
                    TipoConta tipoConta : TipoConta.values()) {
                System.out.println(j + " - " + tipoConta);
                j++;
            }
        } else {
            for (
                    TipoContaJuridica tipoContaJuridica : TipoContaJuridica.values()) {
                System.out.println(j + " - " + tipoContaJuridica);
                j++;
            }
        }

        int tipoContaIn = sc.nextInt();
        String tipoContaIn2 = TipoConta(tipoContaIn, tipoPessoaIn2, j);
        InseriConta(nome, documento, tipoPessoaIn2, tipoContaIn2);

    }

    public static String TipoPessoa(String documento) {

        String tipoPessoaIn1 = null;
        switch (documento.length()) {
            case 11:
                tipoPessoaIn1 = String.valueOf(TipoPessoa.PESSOA_FISICA);
                break;
            case 14:
                tipoPessoaIn1 = String.valueOf(TipoPessoa.PESSOA_JURIDICA);
                break;
            default:
                System.out.println("Valor de documento Inválido");
        }
        return tipoPessoaIn1;
    }

    public static String TipoConta(int tipoContaIn, String tipoPessoaIn2, int j) {

        String tipoContaIn2 = null;
        if (tipoContaIn >= j) {
            System.out.println("Valor de Tipo Conta Inválido");
        } else if (tipoPessoaIn2.equals(TipoPessoa.PESSOA_FISICA.toString())) {
            TipoConta[] tipoContaIn1 = TipoConta.values();
            tipoContaIn2 = String.valueOf(tipoContaIn1[tipoContaIn]);
        } else {
            TipoContaJuridica[] tipoContaIn1 = TipoContaJuridica.values();
            tipoContaIn2 = String.valueOf(tipoContaIn1[tipoContaIn]);
        }
        return tipoContaIn2;
    }

    public static void InseriConta(String nome, String documento, String tipoPessoaIn2, String tipoContaIn2) {
        GestaoClientesContas gestaoClientesContas = new GestaoClientesContas();

        Integer idContaCorrente = 0;
        Integer idContaPoupanca = 0;
        Integer idContaInvestimento = 0;
        Integer idConta = 0;

        gestaoClientesContas.maxIdsContas();

        if (tipoContaIn2.equals(TipoConta.CONTA_CORRENTE.toString())) {
            idContaCorrente = gestaoClientesContas.getIdContaCorrenteMax() + 1;
            System.out.println("Id Conta Corrente: "+gestaoClientesContas.getIdContaCorrenteMax());
            idConta = idContaCorrente;
        } else if (tipoContaIn2.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
            idContaInvestimento = gestaoClientesContas.getIdContaInvestimentoMax() + 1;
            System.out.println("Id Conta Investimento: "+gestaoClientesContas.getIdContaInvestimentoMax());
            idConta = idContaInvestimento;
        } else {
            idContaPoupanca = gestaoClientesContas.getIdContaInvestimentoMax() + 1;
            System.out.println("Id Conta Poupanca: "+gestaoClientesContas.getIdContaInvestimentoMax());
            idConta = idContaPoupanca;
        }

        if (!gestaoClientesContas.validaIdCliente(nome, documento, tipoPessoaIn2)) {
            gestaoClientesContas.criarCliente(nome, documento, tipoPessoaIn2);
            gestaoClientesContas.criarNovoCadastro(documento, idContaCorrente, idContaPoupanca, idContaInvestimento);
            gestaoClientesContas.criarConta(idConta, documento, tipoPessoaIn2);
            System.out.println("Cliente cadastrado com sucesso!");
        }else {
            gestaoClientesContas.validaContasCliente(documento,idConta,idConta,idConta);
            if (gestaoClientesContas.getIdContaCorrente()!=0){
                System.out.println("Cliente tem conta corrente");
            }
            if (gestaoClientesContas.getIdContaInvestimento()!=0) {
                System.out.println("Cliente tem conta investimento");
            }
            if (gestaoClientesContas.getIdContaPoupanca()!=0){
                System.out.println("Cliente tem conta poupança");
            }

            System.out.println("Cliente já cadastrado!");
        }

    }

}
