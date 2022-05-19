package productservice.infrastructure.mappers;

import productservice.infrastructure.entity.Product;
import productservice.pojo.ProductDTO;

import java.util.List;

public interface ProductMapper {
    ProductDTO ProductToProductDto(Product Product);

    Product ProductDtoToProduct(ProductDTO ProductDto);

    List<ProductDTO> ProductListToProductDtoList(List<Product> ProductList);

    List<Product> ProductDtoListToProductList(List<ProductDTO> ProductDtoList);
}
