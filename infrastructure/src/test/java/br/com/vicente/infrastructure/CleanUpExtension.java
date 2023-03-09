package br.com.vicente.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;

public class CleanUpExtension implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        final Collection<CrudRepository> repositories =
                SpringExtension
                        .getApplicationContext(context)
                        .getBeansOfType(CrudRepository.class)
                        .values();
        cleanUp(repositories);
    }

    private void cleanUp(Collection<CrudRepository> repositories){
        repositories.forEach(CrudRepository::deleteAll);
    }

}
