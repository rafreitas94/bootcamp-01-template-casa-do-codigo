package br.com.itau.casadocodigo.service;

import br.com.itau.casadocodigo.model.Autor;
import br.com.itau.casadocodigo.repository.CasaDoCodigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class CasaDoCodigoService {

    @Autowired
    private CasaDoCodigoRepository casaDoCodigoRepository;

    /**
     * Contagem de carga intrínseca na Service: 2
     * @param autor Objeto de domínio
     */
    public void cadastraAutor(Autor autor) {
        autor.setHoraCadastro(Date.from(Instant.now()));
        casaDoCodigoRepository.save(autor);
    }
}
