package application;

public class ValidaException extends Exception{
    private String codErro = "0001";

    public ValidaException(String mensagemErro) {
        super(mensagemErro);
    }

    public ValidaException(String codErro, String mensagemErro) {
        super(mensagemErro);
        this.codErro = codErro;
    }

    public String getCodErro() {
        return codErro;
    }
}
