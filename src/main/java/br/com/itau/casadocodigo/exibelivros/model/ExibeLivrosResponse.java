package br.com.itau.casadocodigo.exibelivros.model;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.novoautor.model.Autor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExibeLivrosResponse {

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

    public ExibeLivrosResponse(ExibeLivros exibeLivros) {
        this.id = exibeLivros.getId();
        this.titulo = exibeLivros.getTitulo();
        this.sumario = exibeLivros.getSumario();
        this.preco = exibeLivros.getPreco();
        this.numeroPaginas = exibeLivros.getNumeroPaginas();
        this.isbn = exibeLivros.getIsbn();
        this.dataLancamento = exibeLivros.getDataLancamento();
        this.autor = exibeLivros.getAutor();
        this.categoria = exibeLivros.getCategoria();
    }
}
