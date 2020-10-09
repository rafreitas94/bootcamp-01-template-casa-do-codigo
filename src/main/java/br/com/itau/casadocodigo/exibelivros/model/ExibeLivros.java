package br.com.itau.casadocodigo.exibelivros.model;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.novoautor.model.Autor;
import br.com.itau.casadocodigo.novolivro.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExibeLivros {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private LocalDate dataLancamento;
    private Autor autor;
    private Categoria categoria;

    public ExibeLivros(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.autor = livro.getAutor();
        this.categoria = livro.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
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

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
