package shoppingcartviewer.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "ShoppingCart")
public class ShoppingCart {
    @Id
    private long id;
    private Customer customer;
    private List<Product> products;
    private String status;

}
