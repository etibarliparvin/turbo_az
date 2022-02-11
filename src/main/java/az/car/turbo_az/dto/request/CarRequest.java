package az.car.turbo_az.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarRequest {

    private String mark;
    private String model;
    private Integer year;
    private BigDecimal cost;
    private Double engine;
    private Long km;
    private String color;
}
