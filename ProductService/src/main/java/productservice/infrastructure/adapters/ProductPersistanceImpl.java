package productservice.infrastructure.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import productservice.infrastructure.entity.Product;
import productservice.infrastructure.mappers.ProductMapperImpl;
import productservice.infrastructure.repository.IProductRepository;
import productservice.pojo.ProductDTO;
import productservice.service.ProductPersistencePort;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductPersistanceImpl implements ProductPersistencePort {
    @Autowired
    private IProductRepository repository;

    @Override
    public ProductDTO addProduct(ProductDTO dtoModel) {
        ProductMapperImpl ProductMapper = new ProductMapperImpl();
        Product Product = ProductMapper.ProductDtoToProduct(dtoModel);
        Product ProductSaved = repository.save(Product);
        return ProductMapper.ProductToProductDto(ProductSaved);
    }


    @Override
    public void deleteProductById(long id) {
        Optional<Product> Product = repository.findById(id);
        repository.deleteById(Product.get().getId());
    }

    @Override
    public ProductDTO updateProduct(ProductDTO ProductDto) {

        return addProduct(ProductDto);
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> ProductList = repository.findAll();
        ProductMapperImpl ProductMapper = new ProductMapperImpl();
        List<ProductDTO> ProductDtoList = ProductMapper.ProductListToProductDtoList(ProductList);
        return ProductDtoList;
    }

    @Override
    public ProductDTO getProductById(long id) {
        ProductMapperImpl ProductMapper = new ProductMapperImpl();
        Optional<Product> Product = repository.findById(id);
        if (Product.isPresent()) {
            return ProductMapper.ProductToProductDto(Product.get());
        }
        return null;
    }
}
