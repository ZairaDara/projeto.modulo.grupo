package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ValidaException, FuncaoNaoExistente{

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println(" ************************************");
        System.out.println(" *** Programa simule App bancário ***");
        System.out.println(" ************************************");

        int opcao = 0;
        do {
            System.out.println("------- MENU PRINCIPAL -------");
            System.out.println("Selecione a operação desejada: ");
            System.out.println("1- Criar uma conta nova");
            System.out.println("2- Realizar uma operacao");
            System.out.println("3- Consultar dados de todas as contas");
            System.out.println("4- Encerrar o programa.");

            //Tratamento de erro da opção informada pelo usuário
            boolean opcaoValida = false;
            while (!opcaoValida) {
                try {
                    opcao = sc.nextInt();
                    opcaoValida = true;
                } catch (InputMismatchException e) {
                    sc.nextLine(); //necessário limpar o buffer do scanner para não dar looping infinito!
                    System.out.println("Opção Inválida! Informe uma função numérica!");
                }
            }

            validarFuncao(opcao);
        }while (opcao != 4);
    }

    public static void validarFuncao(int opcao) throws FuncaoNaoExistente{

        CriadorConta criadorConta = new CriadorConta();
        MenuOperacoes menuOperacoes = new MenuOperacoes();

        switch (opcao) {
            case 1:
                System.out.println("FUNÇÃO 1 - Cadastro de Contas");

                criadorConta.criadorConta();

                break;
            case 2:
                System.out.println("FUNÇÃO 2 - Realizar operações");

                menuOperacoes.SelecionaOpcao();
                break;
            case 3:
                System.out.println("FUNÇÃO 3 - Imprimir todas as informações de todas as contas");
                CriadorConta.gestaoClientesContas.listaTodasAsContas();

                break;
            case 4:
                System.out.println("FUNÇÃO 4 - Programa encerrado!");
                break;
            default:
                System.out.println("ATENÇÃO: Função não existente. Informe uma opção válida!");
        }
       // return opcaoValida;
    }
}


