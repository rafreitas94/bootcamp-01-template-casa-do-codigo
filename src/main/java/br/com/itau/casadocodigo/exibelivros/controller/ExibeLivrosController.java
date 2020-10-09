package br.com.itau.casadocodigo.exibelivros.controller;

import br.com.itau.casadocodigo.exibelivros.repository.ExibeLivrosRepository;
import br.com.itau.casadocodigo.novolivro.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class ExibeLivrosController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ExibeLivrosRepository exibeLivrosRepository;

    @GetMapping(value = "/v1/lista")
    public List<Livro> exibeLista() {
        Query query = entityManager.createQuery("select b from Livro b");
        List<Livro> resultList = query.getResultList();

        return resultList;
    }
}
