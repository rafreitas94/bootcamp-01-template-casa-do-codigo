package br.com.itau.casadocodigo.novoautor.repository;

import br.com.itau.casadocodigo.novoautor.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CasaDoCodigoRepository extends CrudRepository<Autor, String> {

    Optional<Autor> findByEmail(String email);
}
