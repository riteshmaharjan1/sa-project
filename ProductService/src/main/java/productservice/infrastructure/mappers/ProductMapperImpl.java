package productservice.infrastructure.mappers;

import org.modelmapper.ModelMapper;
import productservice.infrastructure.entity.Product;
import productservice.pojo.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO ProductToProductDto(Product Product) {
        ModelMapper mapper = new ModelMapper();
        ProductDTO dto = mapper.map(Product, ProductDTO.class);
        return dto;
    }

    @Override
    public Product ProductDtoToProduct(ProductDTO ProductDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(ProductDto, Product.class);
    }

    @Override
    public List<ProductDTO> ProductListToProductDtoList(List<Product> ProductList) {
        return ProductList.stream().map(Product -> ProductToProductDto(Product)).collect(Collectors.toList());
    }

    @Override
    public List<Product> ProductDtoListToProductList(List<ProductDTO> ProductDtoList) {
        return ProductDtoList.stream().map(ProductDto -> ProductDtoToProduct(ProductDto)).collect(Collectors.toList());
    }
}
