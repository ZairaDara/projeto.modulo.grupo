package application;

import entities.Cliente;
import entities.Conta;
import entities.SaldoConta;
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
        InseriConta(nome,documento,tipoPessoaIn2,tipoContaIn2);

    }

    public static String TipoPessoa(String documento) {

        String tipoPessoaIn1 = null;
        switch (documento.length()) {
            case 11:
                tipoPessoaIn1 = String.valueOf(TipoPessoa.PESSOA_FISICA);
                break;
            case 14:
                tipoPessoaIn1 = String.valueOf(TipoPessoa.PESSOA_JURICA);
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

    public static void InseriConta(String nome,String documento,String tipoPessoaIn2,String tipoContaIn2) {
        GestaoClientesContas gestaoClientesContas = new GestaoClientesContas();
        if(!gestaoClientesContas.validaIdCliente(nome, documento, tipoPessoaIn2)){
            gestaoClientesContas.criarCliente(nome, documento, tipoPessoaIn2);
            gestaoClientesContas.maxIdsContas();
        }

    }

}
