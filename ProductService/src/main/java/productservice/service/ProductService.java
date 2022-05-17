package productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productservice.pojo.Product;
import productservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(int productNumber) {
        Optional<Product> searchProductResult = productRepository.findById(productNumber);
        if (searchProductResult.isPresent()) return searchProductResult.get();
        else {
            System.out.println("Unable To Find Product");
            return null;
        }
    }

    @Override
    public Product insertProduct(Product product) {
        if (productExists(product.getProductNumber())) {
            return null;
        } else {
            return productRepository.save(product);
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer productNumber) {
        productRepository.deleteById(productNumber);
    }

    @Override
    public Product updateProduct(Product product) {
        if (productExists(product.getProductNumber())) {
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public boolean hasProductWithQuantity(Product p, int quantity) {
        boolean hasEnough = false;
        Optional<Product> product = productRepository.findById(p.getProductNumber());
        if (product.isPresent()) {
            if (product.get().getStockNumber() >= quantity)
                hasEnough = true;
        }
        return hasEnough;
    }

    @Override
    public boolean productExists(Integer productNumber) {
        return productRepository.existsById(productNumber);
    }
}
