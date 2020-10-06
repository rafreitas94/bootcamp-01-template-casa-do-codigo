package br.com.itau.casadocodigo.novoautor.model;

public class ResultadoEmailResponse {

    private final String mensagem;

    public ResultadoEmailResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public static ResultadoEmailResponse duplicado(String email) {
        return new ResultadoEmailResponse("O e-mail " + email + " está duplicado. Favor utilizar outro.");
    }

    public ResultadoEmailResponse get() {
        return new ResultadoEmailResponse(mensagem);
    }
}
