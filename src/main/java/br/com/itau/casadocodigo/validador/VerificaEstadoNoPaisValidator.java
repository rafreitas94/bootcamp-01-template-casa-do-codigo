package br.com.itau.casadocodigo.validador;

import br.com.itau.casadocodigo.cadastrocliente.model.ClienteRequest;
import br.com.itau.casadocodigo.cadastropaisestado.model.Estado;
import br.com.itau.casadocodigo.cadastropaisestado.model.Pais;
import br.com.itau.casadocodigo.cadastrocliente.repository.CadastroEstadoRepository;
import br.com.itau.casadocodigo.cadastrocliente.repository.CadastroPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaEstadoNoPaisValidator implements Validator {
//1
    @Autowired
    private CadastroPaisRepository cadastroPaisRepository;
//1
    @Autowired
    private CadastroEstadoRepository cadastroEstadoRepository;

    @Override
    public boolean supports(Class<?> aClass) { //Garante que a classe é mãe ou filha da classe que quero validar
        return ClienteRequest.class.isAssignableFrom(aClass); //Verifico se a classe pode ser validada
    }

    @Override
    public void validate(Object object, Errors errors) {
        ClienteRequest clienteRequest = (ClienteRequest) object;
//1
        Optional<Pais> pais = cadastroPaisRepository.findByPais(clienteRequest.getPais());
        Optional<Estado> estado = cadastroEstadoRepository.findByEstado(clienteRequest.getEstado());
//1 1
        if (pais.isPresent() && estado.isPresent()) {
            if (estado.get().ValidaEstadoAoPais(pais.get())) {
                return;
            }
        }

        errors.rejectValue("estado", null, "Estado não corresponde ao país selecionado.");
    }
}
