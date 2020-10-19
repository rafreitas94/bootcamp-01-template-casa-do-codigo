package br.com.itau.casadocodigo.cadastrocliente.controller;

import br.com.itau.casadocodigo.cadastrocliente.model.Cliente;
import br.com.itau.casadocodigo.cadastrocliente.model.ClienteRequest;
import br.com.itau.casadocodigo.cadastrocliente.model.ClienteResponse;
import br.com.itau.casadocodigo.validador.VerificaEstadoNoPaisValidator;
import br.com.itau.casadocodigo.validador.VerificaPrecoDaCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastroClienteController {

    @Autowired
    private VerificaEstadoNoPaisValidator verificaEstadoNoPaisValidator;

    @Autowired
    private VerificaPrecoDaCompra verificaPrecoDaCompra;

    @PersistenceContext
    private EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(verificaEstadoNoPaisValidator, verificaPrecoDaCompra);
    }

    /**
     * Contagem de carga intrínseca no Controller: 5
     * @param clienteRequest recebe os dados do cliente e da compra
     * @param builder retorna a url da compra
     * @return os dados do cliente e compra salvos no banco
     */
    @PostMapping(value = "/v1/cliente")
    @Transactional
    public ResponseEntity<ClienteResponse> CadastraCliente(@RequestBody @Valid ClienteRequest clienteRequest, UriComponentsBuilder builder) {
        Cliente cliente = clienteRequest.toClienteModel();
        entityManager.persist(cliente);
        URI enderecoCadastroCliente = builder.path("/v1/compra/{id}").build(cliente.getId());
        return ResponseEntity.created(enderecoCadastroCliente).body(new ClienteResponse(cliente));
    }
}
