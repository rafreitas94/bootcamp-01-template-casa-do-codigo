package br.com.itau.casadocodigo.cadastrocategoria.validator;

import br.com.itau.casadocodigo.cadastrocategoria.model.Categoria;
import br.com.itau.casadocodigo.cadastrocategoria.model.CategoriaRequest;
import br.com.itau.casadocodigo.cadastrocategoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Configuration
public class ProibeCategoriaDuplicadaAutorValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoriaRequest categoriaRequest = (CategoriaRequest) target;

        Optional<Categoria> possivelCategoria = categoriaRepository.findByNomeCategoria(categoriaRequest.getNomeCategoria());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nomeCategoria", null,
                    "Já existe a categoria cadastrada: "
                            + categoriaRequest.getNomeCategoria());
        }
    }
}
