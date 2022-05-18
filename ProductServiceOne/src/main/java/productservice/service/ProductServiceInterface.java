package productservice.service;

import productservice.pojo.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product getProduct(int productNumber);

    Product insertProduct(Product product);

    List<Product> getAllProduct();

    void deleteProduct(Integer productNumber);

    Product updateProduct(Product product);

    boolean hasProductWithQuantity(Product p, int quantity);

    boolean productExists(Integer customerId);
}
