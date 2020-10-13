package br.com.itau.casadocodigo.cadastropaisestado.model;

import br.com.itau.casadocodigo.validador.AtributoUnico;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @AtributoUnico(nomeDoAtributo = "nomePais", classeDeDominio = Pais.class)
    private String nomePais;

    public String getNomePais() {
        return nomePais;
    }

    public Pais toModel() {
        return new Pais(this.nomePais);
    }
}
