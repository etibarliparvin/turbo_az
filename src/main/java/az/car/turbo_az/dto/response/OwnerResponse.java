package az.car.turbo_az.dto.response;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OwnerResponse {

    private Long id;
    private String name;
    private String surname;
    private String fin;
    private LocalDate birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean isActive;
    private AddressResponse address;
    private List<PhoneResponse> phones;
    private List<CarResponse> cars;
}
