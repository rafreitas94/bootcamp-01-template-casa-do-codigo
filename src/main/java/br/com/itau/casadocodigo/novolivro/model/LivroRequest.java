package br.com.itau.casadocodigo.novolivro.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal precoLivro;
    @NotNull
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    @NotNull
    private Long idAutor;
    @NotNull
    private Long idCadastro;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCadastro() {
        return idCadastro;
    }

    public Livro toModel(){
        return new Livro(this.titulo, this.resumo, this.sumario, this.precoLivro, this.numeroPaginas,
                this.isbn, this.dataLancamento);
    }
}
