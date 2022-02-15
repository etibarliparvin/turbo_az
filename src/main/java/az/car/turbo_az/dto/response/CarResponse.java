package az.car.turbo_az.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CarResponse {

    private Long id;
    private String mark;
    private String model;
    private Integer year;
    private BigDecimal cost;
    private Double engine;
    private Long km;
    private String color;
    private Boolean isSold;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<String> images;
}
