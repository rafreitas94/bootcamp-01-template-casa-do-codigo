package br.com.itau.casadocodigo.novoautor.model;

import java.time.LocalDateTime;

public class AutorResponse {

    private final String id;
    private final String nome;
    private final LocalDateTime horaCadastro;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getHoraCadastro() {
        return horaCadastro;
    }

    public AutorResponse(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.horaCadastro = autor.getHoraCadastro();
    }
}