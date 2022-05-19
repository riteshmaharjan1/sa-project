package productservice.service;

import productservice.pojo.Product;
import productservice.pojo.ProductDTO;

import java.util.List;

public interface ProductServiceInterface {
    ProductDTO addProduct(ProductDTO dtoModel);

    void deleteProductById(long id);

    ProductDTO updateProduct(ProductDTO dtoModel);

    List<ProductDTO> getProducts();

    ProductDTO getProductById(long id);
}
