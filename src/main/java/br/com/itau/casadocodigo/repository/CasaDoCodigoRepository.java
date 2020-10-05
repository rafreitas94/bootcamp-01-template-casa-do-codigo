package br.com.itau.casadocodigo.repository;

import br.com.itau.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CasaDoCodigoRepository extends CrudRepository<Autor, String> {

    Optional<Autor> findByEmail(String email);
}
