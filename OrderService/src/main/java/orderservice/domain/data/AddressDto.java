package orderservice.domain.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDto {
    private String street;
    private String city;
    private String zip;
}