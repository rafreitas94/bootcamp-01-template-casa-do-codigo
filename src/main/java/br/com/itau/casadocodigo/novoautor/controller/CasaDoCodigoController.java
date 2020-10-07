package br.com.itau.casadocodigo.novoautor.controller;

import br.com.itau.casadocodigo.novoautor.model.Autor;
import br.com.itau.casadocodigo.novoautor.model.AutorRequest;
import br.com.itau.casadocodigo.novoautor.model.AutorResponse;
import br.com.itau.casadocodigo.novoautor.validator.ProibeEmailDuplicadoAutorValidator;
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
public class CasaDoCodigoController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping(value = "/v1/casadocodigo")
    @Transactional
    public ResponseEntity<AutorResponse> gravar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();

        entityManager.persist(autor);
        return ResponseEntity.status(HttpStatus.OK).body(new AutorResponse(autor));
    }
}
