package productservice.service;

import productservice.pojo.ProductDTO;

import java.util.List;

public interface ProductPersistencePort {
    ProductDTO addProduct(ProductDTO dtoModel);

    void deleteProductById(long id);

    ProductDTO updateProduct(ProductDTO dtoModel);

    List<ProductDTO> getProducts();

    ProductDTO getProductById(long id);
}
