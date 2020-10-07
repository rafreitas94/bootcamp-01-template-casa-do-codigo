package br.com.itau.casadocodigo.cadastrocategoria.controller;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.cadastrocategoria.model.CategoriaRequest;
import br.com.itau.casadocodigo.cadastrocategoria.model.CategoriaResponse;
import br.com.itau.casadocodigo.cadastrocategoria.repository.CategoriaRepository;
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
public class CadastroCategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    private final CategoriaRepository categoriaRepository;

    public CadastroCategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping(value = "/v1/categoria")
    @Transactional
    public ResponseEntity<CategoriaResponse> cadastro(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();

        if(categoriaRepository.findByNomeCategoria(categoria.getNomeCategoria()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        entityManager.persist(categoria);

        return ResponseEntity.status(HttpStatus.OK).body(new CategoriaResponse(categoria));
    }
}
