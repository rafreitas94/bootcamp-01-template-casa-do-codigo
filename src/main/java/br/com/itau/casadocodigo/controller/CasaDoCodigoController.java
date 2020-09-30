package br.com.itau.casadocodigo.controller;

import br.com.itau.casadocodigo.dto.AutorRequest;
import br.com.itau.casadocodigo.dto.AutorResponse;
import br.com.itau.casadocodigo.model.Autor;
import br.com.itau.casadocodigo.service.CasaDoCodigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CasaDoCodigoController {

    @Autowired
    private CasaDoCodigoService casaDoCodigoService;

    /**
     * Contagem de carga intrínseca no Controller: 4
     * @param autorRequest recebe na entrada: nome, email e descricao
     * @return um Json de id, nome e data/hora
     */
    @PostMapping(value = "/v1/casadocodigo")
    public ResponseEntity<AutorResponse> gravar(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        casaDoCodigoService.cadastraAutor(autor);
        return ResponseEntity.status(HttpStatus.OK).body(new AutorResponse(autor));
    }
}
