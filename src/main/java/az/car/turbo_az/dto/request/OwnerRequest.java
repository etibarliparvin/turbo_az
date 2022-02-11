package az.car.turbo_az.dto.request;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OwnerRequest {

    private String name;
    private String surname;
    private String fin;
    private LocalDate birthdate;
    private AddressRequest address;
    private PhoneRequest phone;
    private CarRequest car;
}
