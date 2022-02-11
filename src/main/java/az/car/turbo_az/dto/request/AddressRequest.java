package az.car.turbo_az.dto.request;

import lombok.Data;

@Data
public class AddressRequest {

    private String country;
    private String city;
    private String street;
    private String email;
}
