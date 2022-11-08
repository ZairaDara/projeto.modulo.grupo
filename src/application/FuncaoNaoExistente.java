package application;

public class FuncaoNaoExistente extends ValidaException{
    public FuncaoNaoExistente(String mensagem) {
        super(mensagem);
    }

    public FuncaoNaoExistente(String codigo, String mensagem) {
        super(codigo, mensagem);
    }
}
