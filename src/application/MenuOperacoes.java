package application;

import entities.enums.TipoConta;
import entities.enums.TipoContaJuridica;
import entities.enums.TipoOperacao;
import entities.enums.TipoPessoa;

import java.util.Scanner;

public class MenuOperacoes {

    Scanner scanner = new Scanner(System.in);

    public void SelecionaOpcao(){

        System.out.println(" Selecione a operacao que deseja realizar: ");
        System.out.println("1- Sacar");
        System.out.println("2- Depositar");
        System.out.println("3- Transferir");
        System.out.println("4- Investir");

        Integer opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                System.out.println("1- Sacar");
                OpcaoSacar opcaoSacar = new OpcaoSacar();
                opcaoSacar.sacar();
                break;
            case 2:
                System.out.println("2- Depositar");
                OpcaoDepositar opcaoDepositar = new OpcaoDepositar();
                opcaoDepositar.depositar();
                break;
            case 3:
                System.out.println("3- Transferir");
                break;
            case 4:
                System.out.println("4- Investir");
                break;
            default:
                System.out.println("Retornando ao menu inicial");
                break;

        }
    }

}
