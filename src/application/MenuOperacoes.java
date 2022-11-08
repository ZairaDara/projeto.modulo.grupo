package application;

import entities.enums.TipoConta;
import entities.enums.TipoContaJuridica;
import entities.enums.TipoOperacao;
import entities.enums.TipoPessoa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOperacoes {

    Scanner scanner = new Scanner(System.in);

    public void SelecionaOpcao() {

        System.out.println(" Selecione a operacao que deseja realizar: ");
        System.out.println("1- Sacar");
        System.out.println("2- Depositar");
        System.out.println("3- Transferir");
        System.out.println("4- Investir");

        //Tratamento de erro valida opção de transação na conta.
        Integer opcao = 0;
        boolean opcaoTransacaoValida = false;
        while (!opcaoTransacaoValida) {
            try {
                validarOpcaoTrasacao(opcao = scanner.nextInt());
                opcaoTransacaoValida = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Opção de transação precisa ser numérica!");
            } catch (ValidaOpcaoTransacao e) {
                scanner.nextLine();
                System.out.println("Informe uma opção válida!");
            }
        }
    }

    private void validarOpcaoTrasacao(Integer opcaoTransacao) throws ValidaOpcaoTransacao {
        switch (opcaoTransacao){
            case 1:
                System.out.println("1- Sacar");
                OpcaoSacar opcaoSacar = new OpcaoSacar();
                opcaoSacar.sacar();
                break;
            case 2:
                System.out.println("2- Depositar ou investir");
                OpcaoDepositar opcaoDepositar = new OpcaoDepositar();
                opcaoDepositar.depositar();
                break;
            case 3:
                System.out.println("3- Transferir");
                OpcaoTransferir opcaoTransferir = new OpcaoTransferir();
                opcaoTransferir.tranferir();
                break;
            case 4:
                System.out.println("Retornando ao menu inicial");
                break;
            default:
                throw new ValidaOpcaoTransacao("Opção não disponível!");
        }
    }




}
