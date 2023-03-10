package br.com.vicente.productadm.usecase.addproduct;

import br.com.vicente.productadm.gateway.ProductGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class AddProductUseCaseTest {

    @InjectMocks
    private AddProductUseCase useCase;

    @Mock
    private ProductGateway gateway;

    @Test
    public void givenAValidEntity_whenCallAddProduct_shouldAddProduct(){
        final String expectedName = "Product 1";
        final String expectedDescription = "Novo produto";
        final BigDecimal expectedPrice = BigDecimal.TEN;
        final Integer expectedStock = 5;
        final AddProductInputDto input = new AddProductInputDto(expectedName,expectedDescription , expectedPrice,expectedStock);
        AddProductOutputDto resultOutput = useCase.execute(input);
        Mockito.verify(gateway,Mockito.times(1)).add(Mockito.any());
        Assertions.assertNotNull(resultOutput);
        Assertions.assertEquals(expectedName, resultOutput.name());
        Assertions.assertEquals(expectedDescription, resultOutput.description());
        Assertions.assertEquals(expectedPrice, resultOutput.purchasePrice());
        Assertions.assertEquals(expectedStock, resultOutput.stock());
        Assertions.assertNotNull(resultOutput.createdAt());
        Assertions.assertNotNull(resultOutput.updatedAt());
    }
}
