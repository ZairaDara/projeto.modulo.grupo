package application;

import entities.enums.TipoConta;
import entities.enums.TipoContaJuridica;
import entities.enums.TipoPessoa;

import java.math.BigDecimal;
import java.util.Scanner;

public class OpcaoDepositar {

    GestaoClientesContas gestaoClientesContas = new GestaoClientesContas();
    public void depositar(){
        int j = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o documento do responsavel (CPF ou CNPJ): ");
    String documento = scanner.next();

    CriadorConta criadorConta = new CriadorConta();
    String tipoPessoaDoc = criadorConta.TipoPessoa(documento);

        System.out.println("Digite o tipo da conta desejado: ");
        if (tipoPessoaDoc.equals(TipoPessoa.PESSOA_FISICA.toString())) {
            System.out.println(j + " - " + TipoConta.CONTA_CORRENTE);
            j++;
            System.out.println(j + " - " + TipoConta.CONTA_POUPANCA);
            j++;
            System.out.println(j + " - " + TipoConta.CONTA_INVESTIMENTO);
            j++;
        } else {
            for (
                TipoContaJuridica tipoContaJuridica : TipoContaJuridica.values()) {
                System.out.println(j + " - " + tipoContaJuridica);
                j++;
            }
        }
        int tipoContaEscolhido = scanner.nextInt();

        System.out.println("Informe o valor do deposito ou investimento: ");
        BigDecimal valorDeposito = scanner.nextBigDecimal();

        switch (tipoContaEscolhido){
            case 0:
                System.out.println("chamar o depositar de conta corrente");
                gestaoClientesContas.buscaContaCliente(documento);
                break;
            case 1:
                System.out.printf("chamar o depositar da conta poupança");
                break;
            case 2:
                System.out.printf("chamar depositar da conta investimento");
                break;
            default:
                System.out.println("Programa encerrado!");
                break;
        }




    }
}
