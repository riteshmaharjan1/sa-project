package shoppingcartviewer.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoppingcartviewer.domain.dto.ShoppingCartDTO;
import shoppingcartviewer.domain.ShoppingCart;
import shoppingcartviewer.integration.integrationinterface.ShoppingCartPersistencePort;
import shoppingcartviewer.integration.mappers.ShoppingCartMapperImpl;
import shoppingcartviewer.repository.IShoppingCartRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingCartPersistanceImpl implements ShoppingCartPersistencePort {
    @Autowired
    private IShoppingCartRepository repository;

    @Override
    public ShoppingCartDTO addShoppingCart(ShoppingCartDTO dtoModel) {
        ShoppingCartMapperImpl ShoppingCartMapper = new ShoppingCartMapperImpl();
        ShoppingCart ShoppingCart = ShoppingCartMapper.ShoppingCartDtoToShoppingCart(dtoModel);
        ShoppingCart ShoppingCartSaved = repository.save(ShoppingCart);
        return ShoppingCartMapper.ShoppingCartToShoppingCartDto(ShoppingCartSaved);
    }

    @Override
    public void deleteShoppingCartById(long id) {
        Optional<ShoppingCart> ShoppingCart = repository.findById(id);
        repository.deleteById(ShoppingCart.get().getId());
    }

    @Override
    public ShoppingCartDTO updateShoppingCart(ShoppingCartDTO ShoppingCartDto) {
        return addShoppingCart(ShoppingCartDto);
    }

    @Override
    public List<ShoppingCartDTO> getShoppingCarts() {
        List<ShoppingCart> ShoppingCartList = repository.findAll();
        ShoppingCartMapperImpl ShoppingCartMapper = new ShoppingCartMapperImpl();
        List<ShoppingCartDTO> ShoppingCartDtoList = ShoppingCartMapper.ShoppingCartListToShoppingCartDtoList(ShoppingCartList);
        return ShoppingCartDtoList;
    }

    @Override
    public ShoppingCartDTO getShoppingCartById(long id) {
        ShoppingCartMapperImpl ShoppingCartMapper = new ShoppingCartMapperImpl();
        Optional<ShoppingCart> ShoppingCart = repository.findById(id);
        if (ShoppingCart.isPresent()) {
            return ShoppingCartMapper.ShoppingCartToShoppingCartDto(ShoppingCart.get());
        }
        return null;
    }
}
