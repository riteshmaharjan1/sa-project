package productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productservice.pojo.Product;
import productservice.pojo.ProductDTO;
import productservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductPersistencePort persistencePort;

    @Override
    public ProductDTO addProduct(ProductDTO dtoModel) {
        ProductDTO ProductDTO=persistencePort.addProduct(dtoModel);
        return ProductDTO;
    }

    @Override
    public void deleteProductById(long id) {
        persistencePort.deleteProductById(id);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO dtoModel) {
        return persistencePort.updateProduct(dtoModel);
    }

    @Override
    public List<ProductDTO> getProducts() {
        return persistencePort.getProducts();
    }

    @Override
    public ProductDTO getProductById(long id) {
        return persistencePort.getProductById(id);
    }
}
