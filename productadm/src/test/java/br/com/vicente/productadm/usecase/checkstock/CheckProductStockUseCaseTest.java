package br.com.vicente.productadm.usecase.checkstock;

import br.com.vicente.productadm.domain.ProductEntity;
import br.com.vicente.productadm.gateway.ProductGateway;
import br.com.vicente.productadm.usecase.addproduct.AddProductInputDto;
import br.com.vicente.productadm.usecase.addproduct.AddProductOutputDto;
import br.com.vicente.productadm.usecase.addproduct.AddProductUseCase;
import br.com.vicente.shared.domain.valueobject.IdValueObject;
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
public class CheckProductStockUseCaseTest {

    @InjectMocks
    private CheckProductStockUseCase checkUseCase;

    @InjectMocks
    private AddProductUseCase addUseCase;


    @Mock
    private ProductGateway gateway;

    @Test
    public void givenAValidEntityPersisted_whenCallsCheckProductStock_shouldReturnOK(){
        final String expectedName = "Product 1";
        final String expectedDescription = "Novo produto";
        final BigDecimal expectedPrice = BigDecimal.TEN;
        final Integer expectedStock = 5;

        final AddProductInputDto addInput = new AddProductInputDto(expectedName,expectedDescription , expectedPrice,expectedStock);
        AddProductOutputDto resultOutput = addUseCase.execute(addInput);

        ProductEntity product = ProductEntity.newProductEntity(
                IdValueObject.from(resultOutput.id()),
                resultOutput.name(),
                resultOutput.description(),
                resultOutput.purchasePrice(),
                resultOutput.stock());
        final String expectedId = resultOutput.id();

        Mockito.when(gateway.findById(expectedId)).thenReturn(
                Optional.of(product)
        );


        final CheckProductStockInputDto checkInput = new CheckProductStockInputDto(expectedId);
        CheckProductStockOutputDto checkOutput = checkUseCase.execute(checkInput);

        Mockito.verify(gateway,Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(checkOutput);
        Assertions.assertEquals(expectedStock, checkOutput.stock());
        Assertions.assertEquals(expectedId, checkOutput.productId());



    }
}
