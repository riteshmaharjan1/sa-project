package shoppingcartviewer.domain.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCartDTO {
    private long id;
    private CustomerDTO customer;
    private List<ProductDTO> products;
    private String status;

    public void addProduct(ProductDTO product)
    {
        if(this.products==null)
            this.products= new ArrayList<>();
        this.products.add(product);
    }

    public void removeProduct(ProductDTO product)
    {
        if(this.products==null)
            this.products= new ArrayList<>();
        ProductDTO model=this.products.stream().filter(x->x.getId()==product.getId()).findFirst().get();
        this.products.remove(model);
    }

    public void updateProduct(ProductDTO product)
    {
        Optional<ProductDTO> model=this.products.stream().filter(x->x.getProductNumber().toUpperCase().equals(product.getProductNumber().toUpperCase())).findFirst();
        model.get().setQuantity(product.getQuantity());
    }
}