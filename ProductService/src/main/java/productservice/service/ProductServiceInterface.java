package productservice.service;

import productservice.pojo.Product;

import java.util.List;

public interface ProductServiceInterface {
    Product getProduct(int productNumber);

    void insertProduct(Product p);

    List<Product> getAllProduct();

    void deleteProduct(Product p);

    void updateProduct(Product product);

    boolean hasProductWithQuantity(Product p, int quantity);
}
