package br.com.itau.casadocodigo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime horaCadastro;

    @Deprecated
    public Autor(){}

    /**
     * Contagem de carga intrínseca na Service: 0
     * @param nome Nome do autor
     * @param email Email do Autor
     * @param descricao Descricao do assunto
     */
    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getHoraCadastro() {
        return horaCadastro;
    }

    public void setHoraCadastro(LocalDateTime horaCadastro) {
        this.horaCadastro = horaCadastro;
    }
}
