package br.com.vicente.storecatalog.usecase.findall;

import br.com.vicente.storecatalog.domain.ProductEntity;
import br.com.vicente.storecatalog.usecase.ProductDto;

import java.util.ArrayList;
import java.util.List;

public record FindAllProductsDto(

        List<ProductDto> products
) {

    public static FindAllProductsDto from(List<ProductEntity> products){
        List<ProductDto> list = new ArrayList<>();
        products.stream().forEach(x->{
            ProductDto dto = new ProductDto(x.getId().getId(),x.getName(),x.getDescription(),x.getSalesPrice());
            list.add(dto);
        });
        return new FindAllProductsDto(list);

    }
}
