package shoppingcartservice.infrastructure.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoppingcartservice.domain.data.ShoppingCartDto;
import shoppingcartservice.domain.ports.spi.ShoppingCartPersistencePort;
import shoppingcartservice.infrastructure.entity.ShoppingCart;
import shoppingcartservice.infrastructure.mappers.ShoppingCartMapperImpl;
import shoppingcartservice.infrastructure.repository.IShoppingCartRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingCartPersistanceImpl implements ShoppingCartPersistencePort {
    @Autowired
    private IShoppingCartRepository repository;

    @Override
    public ShoppingCartDto addShoppingCart(ShoppingCartDto dtoModel) {
        ShoppingCartMapperImpl ShoppingCartMapper = new ShoppingCartMapperImpl();
        ShoppingCart ShoppingCart = ShoppingCartMapper.ShoppingCartDtoToShoppingCart(dtoModel);
        ShoppingCart ShoppingCartSaved = repository.save(ShoppingCart);
        return ShoppingCartMapper.ShoppingCartToShoppingCartDto(ShoppingCartSaved);
    }



    @Override
    public void deleteShoppingCartById(long id) {
        Optional<ShoppingCart> ShoppingCart=repository.findById(id);
        repository.deleteById(ShoppingCart.get().getId());
    }

    @Override
    public ShoppingCartDto updateShoppingCart(ShoppingCartDto ShoppingCartDto) {

        return addShoppingCart(ShoppingCartDto);
    }

    @Override
    public List<ShoppingCartDto> getShoppingCarts() {
        List<ShoppingCart> ShoppingCartList = repository.findAll();
        ShoppingCartMapperImpl ShoppingCartMapper = new ShoppingCartMapperImpl();
        List<ShoppingCartDto> ShoppingCartDtoList = ShoppingCartMapper.ShoppingCartListToShoppingCartDtoList(ShoppingCartList);
        return ShoppingCartDtoList;
    }

    @Override
    public ShoppingCartDto getShoppingCartById(long id) {
        ShoppingCartMapperImpl ShoppingCartMapper = new ShoppingCartMapperImpl();
        Optional<ShoppingCart> ShoppingCart = repository.findById(id);
        if (ShoppingCart.isPresent()) {
            return ShoppingCartMapper.ShoppingCartToShoppingCartDto(ShoppingCart.get());
        }
        return null;
    }
}
