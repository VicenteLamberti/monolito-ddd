package br.com.vicente.storecatalog.usecase.findall;

import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.usecase.ProductOutputDto;

import java.util.ArrayList;
import java.util.List;

public record FindAllProductsOutpurDto(

        List<ProductOutputDto> products
) {

    public static FindAllProductsOutpurDto from(List<ProductEntity> products){
        List<ProductOutputDto> list = new ArrayList<>();
        products.stream().forEach(x->{
            ProductOutputDto dto = new ProductOutputDto(x.getId().getId(),x.getName(),x.getDescription(),x.getSalesPrice());
            list.add(dto);
        });
        return new FindAllProductsOutpurDto(list);

    }
}
