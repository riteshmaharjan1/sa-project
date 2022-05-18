package orderservice.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private long id;
    private String fistName;
    private String lastName;
    private Address address;
    private String phone;
    private String email;
}
