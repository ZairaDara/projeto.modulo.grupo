package application;

import entities.ContaNova;
import entities.enums.TipoConta;
import entities.enums.TipoContaJuridica;
import entities.enums.TipoPessoa;

import java.math.BigDecimal;
import java.util.Scanner;

import static application.CriadorConta.gestaoClientesContas;

public class RealizaTranferencia {

    Scanner scanner = new Scanner(System.in);
    public void efetivatransferencia(){
        int j = 0;
        System.out.println("Digite o valor para transferir: ");
        BigDecimal vltranf = scanner.nextBigDecimal();

        System.out.println("Digite o CPF/CNPJ que irá receber o valor:");
        String docfavorecido = scanner.next();

        System.out.println(("Digite o nome do favorecido:"));
        String nmfavorecido = scanner.next();

        System.out.println("Digite o tipo da conta desejado: ");
        CriadorConta criadorConta = new CriadorConta();
        String tipoPessoaDoc = criadorConta.TipoPessoa(docfavorecido);

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
        TipoConta tipoconta = null;
        switch (tipoContaEscolhido) {
            case 0:
                tipoconta = TipoConta.CONTA_CORRENTE;
                break;
            case 1:
                tipoconta = TipoConta.CONTA_POUPANCA;
                break;
            case 2:
                tipoconta = TipoConta.CONTA_INVESTIMENTO;
                break;
        }


        ContaNova contaNova = gestaoClientesContas.buscaContaCliente(docfavorecido, tipoconta);
        if (contaNova!= null){
            contaNova.depositar(vltranf);
        }else {
            System.out.println(" xxxxxx Cliente não possui conta. Crie uma conta para realizar a operação xxxxxx");
        }

    }

}
