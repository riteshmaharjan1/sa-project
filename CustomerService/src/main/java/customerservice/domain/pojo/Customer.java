package customerservice.domain.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Customer")
public class Customer {
    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";

    @Id
    private long id;
    private String fistName;
    private String lastName;
    private Address address;
    private String phone;
    private String email;
}
