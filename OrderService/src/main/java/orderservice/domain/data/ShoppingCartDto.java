package orderservice.domain.data;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCartDto {
    private long id;
    private CustomerDto customer;
    private List<ProductDto> products;
    private String status;

    public void addProduct(ProductDto product)
    {
        if(this.products==null)
            this.products= new ArrayList<>();
        this.products.add(product);
    }

    public void removeProduct(ProductDto product)
    {
        if(this.products==null)
            this.products= new ArrayList<>();
        ProductDto model=this.products.stream().filter(x->x.getId()==product.getId()).findFirst().get();
        this.products.remove(model);
    }

    public void updateProduct(ProductDto product)
    {
        Optional<ProductDto> model=this.products.stream().filter(x->x.getProductNumber().toUpperCase().equals(product.getProductNumber().toUpperCase())).findFirst();
        model.get().setQuantity(product.getQuantity());
    }
}