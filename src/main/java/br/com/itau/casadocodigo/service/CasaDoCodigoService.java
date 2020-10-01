package br.com.itau.casadocodigo.service;

import br.com.itau.casadocodigo.dto.AutorRequest;
import br.com.itau.casadocodigo.model.Autor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Service
public class CasaDoCodigoService {

    @PersistenceContext
    public EntityManager entityManager;

    /**
     * Contagem de carga intrínseca na Service: 2
     * @param autorRequest recebe na entrada: nome, email e descricao
     */
    public Autor cadastraAutor(AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel();
        autor.setHoraCadastro(LocalDateTime.now());
        entityManager.persist(autor);
        return autor;
    }
}
