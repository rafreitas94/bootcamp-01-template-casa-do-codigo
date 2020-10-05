package br.com.itau.casadocodigo.controller;

import br.com.itau.casadocodigo.model.Autor;
import br.com.itau.casadocodigo.model.AutorRequest;
import br.com.itau.casadocodigo.model.AutorResponse;
import br.com.itau.casadocodigo.model.ResultadoEmailResponse;
import br.com.itau.casadocodigo.repository.CasaDoCodigoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CasaDoCodigoController {

    @PersistenceContext
    private EntityManager entityManager;

    private final CasaDoCodigoRepository casaDoCodigoRepository;

    public CasaDoCodigoController(CasaDoCodigoRepository casaDoCodigoRepository) {
        this.casaDoCodigoRepository = casaDoCodigoRepository;
    }

    /**
     * Contagem de carga intrínseca no Controller: 6
     * @param autorRequest recebe na entrada: nome, email e descricao
     * @return um Json de id, nome e data/hora
     */
    @PostMapping(value = "/v1/casadocodigo")
    @Transactional
    public ResponseEntity<?> gravar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();

        if (casaDoCodigoRepository.findByEmail(autor.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResultadoEmailResponse.duplicado(autor.getEmail())
                            .get());
        }

        entityManager.persist(autor);
        return ResponseEntity.status(HttpStatus.OK).body(new AutorResponse(autor));
    }
}
