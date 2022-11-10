package application;

import entities.Cliente;
import entities.enums.TipoConta;
import entities.enums.TipoContaJuridica;
import entities.enums.TipoPessoa;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class CriadorConta {

    Scanner sc = new Scanner(System.in);
    public static GestaoClientesContas gestaoClientesContas = new GestaoClientesContas();
    //GestaoClientesContas gestaoClientesContas = new GestaoClientesContas();

    public void criadorConta() {

        int j = 0;

        System.out.println("Digite o nome do responsavel: ");
        String nome = sc.next();



        //tratamento de erro do Documento CPF / CNPJ
        String documento = "";
        boolean documentoValido = false;
        while (!documentoValido){
            try {
                System.out.println("Digite o documento do responsavel (CPF ou CNPJ): ");
                validarDocumento(documento = sc.next());
                documentoValido = true;
            } catch (ValidaDocumento e){
                sc.nextLine(); //necessário limpar o buffer do scanner para não dar looping infinito!
                System.out.println("Verifique a quantidade dígitos informados.");
            }
        }

        String tipoPessoaIn2 = validarTipoPessoa(documento);




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

        //Tratamento de erro do tipo de conta
        int tipoContaIn = 9;
        boolean tipoContaValido = false;
        while (!tipoContaValido) {
            try {
                validarTipoConta(tipoContaIn = sc.nextInt(), tipoPessoaIn2);
                tipoContaValido = true;
            } catch (InputMismatchException e){
                sc.nextLine(); //necessário limpar o buffer do scanner para não dar looping infinito!
                System.out.println("Tipo de conta deve ser numérico!");
            } catch (ValidaTipoConta e){
                sc.nextLine(); //necessário limpar o buffer do scanner para não dar looping infinito!
                System.out.println("Informe um tipo de conta válido:");
            }

        }



        String tipoContaIn2 = TipoConta(tipoContaIn, tipoPessoaIn2, j);
        InseriConta(nome, documento, tipoPessoaIn2, tipoContaIn2);
    }

    private void validarTipoConta(int tipoConta, String tipoPessoa) throws ValidaTipoConta{

        if (tipoPessoa.equals(TipoPessoa.PESSOA_FISICA.toString())) {
            if (tipoConta == 0 || tipoConta == 1 || tipoConta == 2) {
                System.out.println("Tipo de conta válido!");
            } else {
                throw new ValidaTipoConta("Tipo de conta inválido!");
            }
        } else if (tipoPessoa.equals(TipoPessoa.PESSOA_JURIDICA.toString())){
            if (tipoConta == 0 || tipoConta == 1) {
                System.out.println("Tipo de conta válido!");
            } else {
                throw new ValidaTipoConta("Tipo de conta inválido!");
            }
        }
    }

    private void validarDocumento(String documento) throws ValidaDocumento{
        if (documento.length() == 11 || documento.length() == 14){
            System.out.println("Documento Válido!");
        }else {
            throw new ValidaDocumento("Documento inválido!");
        }
    }

    public static String validarTipoPessoa(String documento) {

        String tipoPessoaIn1 = "";
        switch (documento.length()) {
            case 11:
                tipoPessoaIn1 = String.valueOf(TipoPessoa.PESSOA_FISICA);
                break;
            case 14:
                tipoPessoaIn1 = String.valueOf(TipoPessoa.PESSOA_JURIDICA);
                break;
            default:
                System.out.println("Documento Inválido!");
                break;
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
        Cliente cliente = null;
        IniciaIdsMax();

        int idContaCorrente = gestaoClientesContas.getIdContaCorrenteMax();
        int idContaPoupanca = gestaoClientesContas.getIdContaPoupancaMax();
        int idContaInvestimento = gestaoClientesContas.getIdContaInvestimentoMax();

        if (tipoContaIn2.equals(TipoConta.CONTA_CORRENTE.toString())) {
            idContaCorrente += 1;
            gestaoClientesContas.setIdContaCorrenteMax(idContaCorrente);
        } else if (tipoContaIn2.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
            idContaInvestimento += 1;
            gestaoClientesContas.setIdContaInvestimentoMax(idContaInvestimento);
        } else {
            idContaPoupanca += 1;
            gestaoClientesContas.setIdContaPoupancaMax(idContaPoupanca);
        }

        if (!gestaoClientesContas.validaIdCliente(documento, nome, tipoPessoaIn2)) {
            cliente = gestaoClientesContas.criarCliente(documento, nome, tipoPessoaIn2);
            if(tipoContaIn2.equals(TipoConta.CONTA_CORRENTE.toString())){
                gestaoClientesContas.criarNovoCadastro(cliente, idContaCorrente, 0, 0);
                gestaoClientesContas.criarConta(idContaCorrente, 0,0, cliente, tipoContaIn2);
                System.out.println("Cliente cadastrado e conta corrente criada com sucesso!");
            } else if (tipoContaIn2.equals(TipoConta.CONTA_POUPANCA.toString())) {
                gestaoClientesContas.criarNovoCadastro(cliente, 0, idContaPoupanca, 0);
                gestaoClientesContas.criarConta(0, idContaPoupanca,0, cliente, tipoContaIn2);
                System.out.println("Cliente cadastrado e conta poupança criada com sucesso!");
            } else if (tipoContaIn2.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
                gestaoClientesContas.criarNovoCadastro(cliente, 0, 0, idContaInvestimento);
                gestaoClientesContas.criarConta(0, 0,idContaInvestimento, cliente, tipoContaIn2);
                System.out.println("Cliente cadastrado e conta investimento criada com sucesso!");
            }else{
                System.out.println("Informacoes de tipo de conta invalida");
            }
        } else {
            boolean ctrlCadastro = false;
            gestaoClientesContas.validaContasCliente(cliente, idContaCorrente, idContaPoupanca, idContaInvestimento);
            if (gestaoClientesContas.getIdContaCorrente() != 0 && tipoContaIn2.equals(TipoConta.CONTA_CORRENTE.toString())) {
                System.out.println("Cliente já possui conta corrente");
                ctrlCadastro = true;
            }
            if (gestaoClientesContas.getIdContaInvestimento() != 0 && tipoContaIn2.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
                System.out.println("Cliente ja possui conta investimento");
                ctrlCadastro = true;
            }
            if (gestaoClientesContas.getIdContaPoupanca() != 0 && tipoContaIn2.equals(TipoConta.CONTA_POUPANCA.toString())) {
                System.out.println("Cliente ja possui conta conta poupança");
                ctrlCadastro = true;
            }
            if (!ctrlCadastro) {
                if (tipoContaIn2.equals(TipoConta.CONTA_CORRENTE.toString())) {
                    gestaoClientesContas.atualizaNovoCadastro(cliente, idContaCorrente, GestaoClientesContas.getIdContaPoupanca(), GestaoClientesContas.getIdContaInvestimento());
                    gestaoClientesContas.criarConta(idContaCorrente, GestaoClientesContas.getIdContaPoupanca(), GestaoClientesContas.getIdContaInvestimento(), cliente, tipoContaIn2);
                    System.out.println("Conta corrente criada para o cliente!");
                } else if (tipoContaIn2.equals(TipoConta.CONTA_POUPANCA.toString())) {
                    gestaoClientesContas.atualizaNovoCadastro(cliente, GestaoClientesContas.getIdContaCorrente(), idContaPoupanca, GestaoClientesContas.getIdContaInvestimento());
                    gestaoClientesContas.criarConta(GestaoClientesContas.getIdContaCorrente(), idContaPoupanca, GestaoClientesContas.getIdContaInvestimento(), cliente, tipoContaIn2);
                    System.out.println("Conta poupança criada para o cliente!");
                } else if (tipoContaIn2.equals(TipoConta.CONTA_INVESTIMENTO.toString())) {
                    gestaoClientesContas.atualizaNovoCadastro(cliente, GestaoClientesContas.getIdContaCorrente(), GestaoClientesContas.getIdContaPoupanca(), idContaInvestimento);
                    gestaoClientesContas.criarConta(GestaoClientesContas.getIdContaCorrente(), GestaoClientesContas.getIdContaPoupanca(), idContaInvestimento, cliente, tipoContaIn2);
                    System.out.println("Conta investimento criada para o cliente!");
                } else {
                    System.out.println("Conta nao identificada");
                }
            }
        }
    }

    public static void IniciaIdsMax() {
        GestaoClientesContas gestaoClientesContas = new GestaoClientesContas();

        Optional<Integer> gestaoClientesContas1 = Optional.ofNullable(gestaoClientesContas.getIdContaCorrenteMax());
        if (!gestaoClientesContas1.isPresent()) {
            gestaoClientesContas.setIdContaCorrenteMax(0);
        }
        Optional<Integer> gestaoClientesContas2 = Optional.ofNullable(gestaoClientesContas.getIdContaPoupancaMax());
        if (!gestaoClientesContas1.isPresent()) {
            gestaoClientesContas.setIdContaPoupancaMax(0);
        }
        Optional<Integer> gestaoClientesContas3 = Optional.ofNullable(gestaoClientesContas.getIdContaInvestimentoMax());
        if (!gestaoClientesContas1.isPresent()) {
            gestaoClientesContas.setIdContaInvestimentoMax(0);
        }
    }
}
