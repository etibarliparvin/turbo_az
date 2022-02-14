package az.car.turbo_az.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OwnerRequest {

    private String name;
    private String surname;
    private String fin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private AddressRequest address;
    private List<PhoneRequest> phones;
    private List<CarRequest> cars;
}
