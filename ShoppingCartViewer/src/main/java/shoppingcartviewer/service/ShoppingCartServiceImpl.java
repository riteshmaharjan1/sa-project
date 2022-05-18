package shoppingcartviewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcartviewer.domain.dto.ProductDTO;
import shoppingcartviewer.domain.dto.ShoppingCartDTO;
import shoppingcartviewer.service.serviceinterface.ShoppingCartServicePort;
import shoppingcartviewer.integration.integrationinterface.ShoppingCartPersistencePort;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartServicePort {

    @Autowired
    private ShoppingCartPersistencePort persistencePort;

    @Override
    public ShoppingCartDTO addShoppingCart(ShoppingCartDTO dtoModel) {
        ShoppingCartDTO ShoppingCartDTO = persistencePort.addShoppingCart(dtoModel);
        return ShoppingCartDTO;
    }

    @Override
    public ShoppingCartDTO addProduct(long cartId, ProductDTO dtoModel) {
        ShoppingCartDTO cartModel = persistencePort.getShoppingCartById(cartId);
        cartModel.addProduct(dtoModel);
        return persistencePort.updateShoppingCart(cartModel);
    }

    @Override
    public ShoppingCartDTO removeProduct(long cartId, ProductDTO dtoModel) {
        ShoppingCartDTO cartModel = persistencePort.getShoppingCartById(cartId);
        cartModel.removeProduct(dtoModel);
        return persistencePort.updateShoppingCart(cartModel);
    }

    @Override
    public ShoppingCartDTO updateProduct(long cartId, ProductDTO dtoModel) {
        ShoppingCartDTO cartModel = persistencePort.getShoppingCartById(cartId);
        cartModel.updateProduct(dtoModel);
        return persistencePort.updateShoppingCart(cartModel);
    }

    @Override
    public void deleteShoppingCartById(long id) {
        persistencePort.deleteShoppingCartById(id);
    }

    @Override
    public ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dtoModel) {
        return persistencePort.updateShoppingCart(dtoModel);
    }

    @Override
    public List<ShoppingCartDTO> getShoppingCarts() {
        return persistencePort.getShoppingCarts();
    }

    @Override
    public ShoppingCartDTO getShoppingCartById(long id) {
        return persistencePort.getShoppingCartById(id);
    }
}
