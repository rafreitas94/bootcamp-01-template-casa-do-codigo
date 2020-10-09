package br.com.itau.casadocodigo.exibelivros.repository;

import br.com.itau.casadocodigo.novolivro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExibeLivrosRepository extends JpaRepository<Livro, Long> {
}
