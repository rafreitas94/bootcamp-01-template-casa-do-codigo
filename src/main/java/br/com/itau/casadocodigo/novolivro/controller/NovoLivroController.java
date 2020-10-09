package br.com.itau.casadocodigo.novolivro.controller;

import br.com.itau.casadocodigo.novolivro.model.Livro;
import br.com.itau.casadocodigo.novolivro.model.LivroRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NovoLivroController {

    @PostMapping(value = "/v1/livro")
    public ResponseEntity<Livro> publicaLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }
}
