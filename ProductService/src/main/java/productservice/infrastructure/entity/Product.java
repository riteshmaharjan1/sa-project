package productservice.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";

    @Id
    private long id;
    private String productNumber;
    private String name;
    private double price;
    private Boolean taxable;
    private double applicableDiscount;
    private String description;
    private int numberInStock;
}
