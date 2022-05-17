package shoppingcartservice.service;

import shoppingcartservice.pojo.Product;
import shoppingcartservice.pojo.ShoppingCart;

public interface ShoppingCartServiceInterface {

    void setShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart getShoppingCart(int customerId);
    void deleteProduct(int customerId, Product product);
    void addProduct(int customerId, Product product);
    void updateQuantity(Product product, int quantity, int customerId);
    int getProductCount(Integer customerId);
}
