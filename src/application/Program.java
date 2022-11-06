package application;

import entities.enums.TipoConta;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println(" *** Programa simule app bancario ***");

        int opcao = 1;
        while (opcao == 1 || opcao == 2 || opcao == 3) {
            System.out.println(" Selecione a opcao desejada: ");
            System.out.println("1- Criar uma conta nova");
            System.out.println("2- Realizar uma operacao");
            System.out.println("3- Consultar dados de todas as contas");
            System.out.println("Qualquer outro numero para encerrar o programa");
            opcao = sc.nextInt();
            Roteador(opcao);
        }
    }

    public static void Roteador(int opcao) {

        CriadorConta criadorConta = new CriadorConta();
        MenuOperacoes menuOperacoes = new MenuOperacoes();

        switch (opcao) {
            case 1:
                System.out.println("Criacao de contas iniciado");
                criadorConta.criadorConta();
                break;
            case 2:
                System.out.println("Opcao de realizar operacoes");
                menuOperacoes.SelecionaOpcao();
            case 3:
                System.out.println("Opcao para imprimir todas as informacoes de todas as contas");
                break;
            default:
                System.out.println("Programa encerrado!");
                break;
        }
    }
}


