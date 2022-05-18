package clientapplication.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private long id;
    private String fistName;
    private String lastName;
    private AddressDto address;
    private String phone;
    private String email;
}