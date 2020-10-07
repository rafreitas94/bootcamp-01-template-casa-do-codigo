package br.com.itau.casadocodigo.novoautor.validator;

import br.com.itau.casadocodigo.novoautor.model.Autor;
import br.com.itau.casadocodigo.novoautor.model.AutorRequest;
import br.com.itau.casadocodigo.novoautor.repository.CasaDoCodigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Configuration
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private CasaDoCodigoRepository casaDoCodigoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AutorRequest request = (AutorRequest) target;

        Optional<Autor> possivelAutor = casaDoCodigoRepository.findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
                            + request.getEmail());
        }
    }
}
