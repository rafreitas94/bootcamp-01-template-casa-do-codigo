package br.com.itau.casadocodigo.cadastropaisestado.model;

public class PaisResponse {

    private final Long id;
    private final String nomePais;

    public Long getId() {
        return id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public PaisResponse(Pais pais) {
        this.id = pais.getId();
        this.nomePais = pais.getNomePais();
    }
}
