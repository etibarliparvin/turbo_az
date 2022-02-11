package az.car.turbo_az.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PhoneResponse {

    private Long id;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
