package az.car.turbo_az.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResponse implements Serializable {

    private Long time = System.currentTimeMillis();
    private String status = "Success";
    private Object item;
    private CommonMessage errorMessage;
}
