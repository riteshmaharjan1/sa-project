package shoppingcartservice.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class ShoppingCart {
    @Id
    private int shoppingCartNumber;
    private final List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public ShoppingCart(Product product) {
        this.products = new ArrayList<>();
        products.add(product);
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public int getShoppingCartNumber() {
        return shoppingCartNumber;
    }

    public void setShoppingCartNumber(int shoppingCartNumber) {
        this.shoppingCartNumber = shoppingCartNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void increaseProductQuantity(Product product) {
        products.get(products.indexOf(product)).setQuantity((product.getQuantity() + 1));
    }

    public int getProductCount() {
        return products.size();
    }

    public boolean checkProduct(Product product) {
        return products.contains(product);
    }
}
