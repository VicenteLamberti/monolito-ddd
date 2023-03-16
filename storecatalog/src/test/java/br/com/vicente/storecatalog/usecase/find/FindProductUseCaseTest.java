package br.com.vicente.storecatalog.usecase.find;

import br.com.vicente.shared.domain.valueobject.IdValueObject;
import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.gateway.StoreCatalogProductGateway;
import br.com.vicente.storecatalog.usecase.ProductOutputDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FindProductUseCaseTest {

    @InjectMocks
    private FindProductUseCase useCase;

    @Mock
    private StoreCatalogProductGateway gateway;

    @Test
    public void  givenAValidEntitiyPersisted_whenCallsFind_shouldReturnAProducts(){

        ProductEntity product1 = ProductEntity.newProductEntity(IdValueObject.from("123"),"Product 1", "Description 1", BigDecimal.TEN);
        String expectedId = product1.getId().getId();

        Mockito.when(gateway.find(expectedId)).thenReturn(Optional.of(product1));

        ProductOutputDto product = useCase.execute(expectedId);
        Assertions.assertEquals(expectedId, product.id());


    }

}
