package orderservice.domain.data;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentInfoDto {
    private long id;
    private String cardNumber;
    private int securityCode;
    private String holderName;

}