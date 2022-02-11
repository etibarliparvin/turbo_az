package az.car.turbo_az.dto.response;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class AddressResponse {

    private Long id;
    private String country;
    private String city;
    private String street;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
