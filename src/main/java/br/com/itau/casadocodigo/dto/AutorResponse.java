package br.com.itau.casadocodigo.dto;

import br.com.itau.casadocodigo.model.Autor;

import java.util.Date;

public class AutorResponse {

    private final String id;
    private final String nome;
    private final Date horaCadastro;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getHoraCadastro() {
        return horaCadastro;
    }

    public AutorResponse(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.horaCadastro = autor.getHoraCadastro();
    }
}
