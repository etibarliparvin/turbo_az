package az.car.turbo_az.exception;

import lombok.Data;

@Data
public class CommonMessage {

    private String message;
    private String code;
    private String description;
}
