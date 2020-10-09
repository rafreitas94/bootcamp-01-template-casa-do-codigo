package br.com.itau.casadocodigo.validador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class AtributoNaoNuloValidator implements ConstraintValidator<AtributoNaoNulo, Long> {

    private String nomeAtributo;
    private Class<?> classeDominio;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(AtributoNaoNulo params) {
        nomeAtributo = params.nomeDoAtributo();
        classeDominio = params.classeDeDominio();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("SELECT 1 FROM " + classeDominio.getName() + " WHERE " + nomeAtributo + " =:VALUE");
        query.setParameter("VALUE", value);
        List<?> list = query.getResultList();
        return !list.isEmpty();
    }
}
