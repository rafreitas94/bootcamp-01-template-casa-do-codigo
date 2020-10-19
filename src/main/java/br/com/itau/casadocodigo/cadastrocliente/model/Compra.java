package br.com.itau.casadocodigo.cadastrocliente.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    private BigDecimal total;
    @NotNull
    @Size(min = 1)
    @ElementCollection
    private List<Itens> itens;
    @OneToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

    @Deprecated
    public Compra() {
    }

    public Compra(@NotNull @Positive BigDecimal total, @NotNull List<Itens> itens) {
        this.total = total;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }
}
