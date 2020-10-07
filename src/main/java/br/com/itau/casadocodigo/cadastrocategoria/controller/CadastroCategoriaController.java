package br.com.itau.casadocodigo.cadastrocategoria.controller;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.cadastrocategoria.model.CategoriaRequest;
import br.com.itau.casadocodigo.cadastrocategoria.model.CategoriaResponse;
import br.com.itau.casadocodigo.cadastrocategoria.repository.CategoriaRepository;
import br.com.itau.casadocodigo.cadastrocategoria.validator.ProibeCategoriaDuplicadaAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    private ProibeCategoriaDuplicadaAutorValidator proibeCategoriaDuplicadaAutorValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(proibeCategoriaDuplicadaAutorValidator);
    }

    @PostMapping(value = "/v1/categoria")
    @Transactional
    public ResponseEntity<CategoriaResponse> cadastro(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();

        entityManager.persist(categoria);

        return ResponseEntity.status(HttpStatus.OK).body(new CategoriaResponse(categoria));
    }
}
